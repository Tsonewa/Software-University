import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        User user = createUser();
        Connection con = user.getConnection();

        Engine engine = new Engine(con);
        engine.run();
    }

    private static User createUser() {
        Scanner sc = new Scanner(System.in);

        User user = new User();
        System.out.println("Enter your db username here:");
        user.setUsername(sc.nextLine());
        System.out.println("Enter password:");
        user.setPassword(sc.nextLine());
        System.out.println("Enter db name:");
        user.setDatabaseName(sc.nextLine());

        return user;
    }
}

