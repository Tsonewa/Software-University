import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Engine implements Runnable{
    private final Connection connection;
    private  final Scanner scanner;

    public Engine(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {

            System.out.println("Enter task number:");
            String task = scanner.nextLine();

            while (true) {
                switch (task) {
                    case "1":
                        this.getVillainsNames();
                        break;
                    case "2":
                        this.getMinionsNames();
                        break;
                    case "3":
                        this.addMinion();
                        break;
                    case "4":
                        this.changeTownNameCasing();
                        break;
                    case "5":
                        this.removeVillain();
                        break;
                    case "6":
                        this.printAllMinionsNames();
                        break;
                    case "7":
                        this.increaseMinionsAge();
                        break;
                    case "8":
                        this.increaseMinionsAgeStoreProcedure();
                        break;
                    case "Exit":
                        return;
                }
                System.out.println("Enter task number:");
                task = scanner.nextLine();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void increaseMinionsAgeStoreProcedure() throws SQLException {

        System.out.println("Enter minion id here:");
        int id = Integer.parseInt(scanner.nextLine());

       CallableStatement cst = this.connection.prepareCall("{call usp_get_older(?)}");
        cst.setInt(1, id);

        try {
            cst.executeUpdate();

            String query = "select name, age from minions where id = ?";

            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                System.out.printf("%s - %s%n", rs.getString("name"), rs.getInt("age"));
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void increaseMinionsAge() throws SQLException {

        System.out.println("Enter minions ids here");
        List<String> split = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        System.out.println("Enter are increasing number here");
        int ages = Integer.parseInt(scanner.nextLine());


        String query = String.format("update minions set name = LOWER(name), age = age + ? WHERE `id` IN (%s)",
                split.stream().collect(Collectors.joining(", ")));

        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, ages);

    ps.executeUpdate();
    printAllMinions();
    }

    private void printAllMinions() throws SQLException {
    String query = "select * from minions";
    PreparedStatement ps = this.connection.prepareStatement(query);
    ResultSet rs = ps.executeQuery();

    while (rs.next()){
        System.out.printf("%d. %s %d%n", rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"));
    }


    }

    private void printAllMinionsNames() throws SQLException {

        String query = "select name from minions";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayDeque<String> stack = new ArrayDeque<>();
        Queue<String> queue = new ArrayDeque<>();
        while (rs.next()){
            stack.push(rs.getString("name"));
            queue.add(rs.getString("name"));
        }

        List<String> orderedMinions = new ArrayList<>();
        while (!stack.isEmpty()){
            orderedMinions.add(queue.poll());
            orderedMinions.add(stack.pop());
            if(stack.size() >= 1){
                stack.removeLast();
            }
        }
        orderedMinions.forEach(System.out::println);
    }

    private void removeVillain() throws SQLException {

        System.out.println("Enter the villain id here:");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            String name = getNameById(id);
            String query = "delete from minions_villains where villain_id = ?";
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);

            int deletedRows = ps.executeUpdate();

            deleteById(id, "villains");

            System.out.printf("%s was deleted%n",name);
            System.out.printf("%d minions released.%n", deletedRows);

        } catch (IndexOutOfBoundsException e){
            System.out.println("No such villain was found.");
        }
    }

    private void deleteById(int id, String tableName) throws SQLException {

        String query = String.format("delete from %s where id = ?", tableName);
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, id);

        ps.executeUpdate();

    }

    private void changeTownNameCasing() throws SQLException {
        System.out.println("Enter the country name here:");
        String country = scanner.nextLine();

String updateQuery = "update towns set name = UPPER(name) where country = ?";
PreparedStatement ps = this.connection.prepareStatement(updateQuery);
ps.setString(1, country);

 int isUpdated = ps.executeUpdate();

 if(isUpdated == 0){
     System.out.println("No town names were affected.");
 } else {
    String query = "SELECT name FROM towns where country = ?";
    PreparedStatement preparedStatement = this.connection.prepareStatement(query);
    preparedStatement.setString(1, country);

    ResultSet resultSet = preparedStatement.executeQuery();

    Set<String> updatedTowns = new LinkedHashSet<>();
    while (resultSet.next()){
        updatedTowns.add(resultSet.getString("name"));
    }
     System.out.println(updatedTowns);
 }
    }

    private void addMinion() throws SQLException {
        System.out.println("Enter minion name, age and town here:");
        String[] minionInfo = scanner.nextLine().split("\\s+");
        System.out.println("Enter villain name here:");
        String villainName = scanner.nextLine().split("\\s+")[0];
        String minionName = minionInfo[0].trim();
        int minionAge = Integer.parseInt(minionInfo[1].trim());
        String townName  = minionInfo[2].trim();

        addTown(townName);
        addVillain(villainName);
        insertMinion(minionName, minionAge, getIdByName(townName, "towns"));

        String query = "insert into minions_villains values (? , ?)";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, getIdByName(minionName, "minions"));
        ps.setInt(2, getIdByName(villainName, "villains"));

        ps.executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private int getIdByName(String name, String tableName) throws SQLException {

        String query = String.format("select id from %s where name = ?", tableName);
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();

        List<Integer> ids = new ArrayList<>();

        while (rs.next()){
            ids.add(rs.getInt("id"));
        }

        return ids.get(0);
    }

    private void insertMinion(String minionName, int minionAge, int townId) throws SQLException {

        String query = "SELECT id FROM minions WHERE name = ?";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, minionName);

        ResultSet rs = ps.executeQuery();

        if(!rs.isBeforeFirst()) {
            String insertQuery = "INSERT INTO minions (name, age, town_id)\n" +
                    "value (?, ?, ?)";

            PreparedStatement insert = this.connection.prepareStatement(insertQuery);
            insert.setString(1, minionName);
            insert.setInt(2, minionAge);
            insert.setInt(3, townId);

            insert.executeUpdate();
            System.out.println();
        }
    }

    private void addVillain(String villainName) throws SQLException {

        String query = "SELECT id FROM villains WHERE name = ?";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, villainName);

        ResultSet rs = ps.executeQuery();

        if(!rs.isBeforeFirst()){
            String addQuery = "INSERT INTO villains (name, evilness_factor)\n" +
                    "value (?, 'evil')";

            PreparedStatement insert = this.connection.prepareStatement(addQuery);
            insert.setString(1, villainName);

            insert.executeUpdate();

            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
    }

    private void addTown(String townName) throws SQLException {

    String query = "SELECT id FROM towns WHERE name = ?";
    PreparedStatement ps = this.connection.prepareStatement(query);
    ps.setString(1, townName);

    ResultSet rs = ps.executeQuery();

    if(!rs.isBeforeFirst()){
        String addQuery = "INSERT INTO towns (name)\n" +
                "value (?);";

        PreparedStatement insert = this.connection.prepareStatement(addQuery);
        insert.setString(1, townName);

        insert.executeUpdate();

        System.out.printf("Town %s was added to the database.%n", townName);
    }
    }

    private void getMinionsNames() throws SQLException {

        System.out.println("Enter villains id:");
        int villainId = Integer.parseInt(this.scanner.nextLine());

        String query = """
                select name, age from minions as m
                join minions_villains as mv on m.id = mv.minion_id
                where villain_id = ?""";

        try {
        String name = getNameById(villainId);
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, villainId);

            ResultSet rs = ps.executeQuery();
            System.out.printf("Villain: %s%n", name);
            while (rs.next()) {
                System.out.printf("%d.%s %d%n", rs.getRow(), rs.getString("name"),
                        rs.getInt("age"));
            }
        }catch (IndexOutOfBoundsException e){
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
        }
    }

    private String getNameById(int villainId) throws SQLException {

        String query = "select name from villains where id = ? limit 1";

    PreparedStatement ps = this.connection.prepareStatement(query);
    ps.setInt(1, villainId);

    ResultSet rs = ps.executeQuery();
        List<String> name = new ArrayList<>();

        while (rs.next()){
            name.add(rs.getString("name"));
        }

        return name.get(0);
    }

    private void getVillainsNames() throws SQLException {

        String query = """
                select name, count(mv.minion_id) as count from villains as v
                join minions_villains as mv on v.id = mv.villain_id
                group by villain_id
                having count > 15
                order by count desc""";

        PreparedStatement ps = this.connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            System.out.printf("%s | %s%n", rs.getString("name"), rs.getInt("count"));
        }
    }
}
