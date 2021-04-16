import java.util.*;

public class SoftuniParking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, String> people = new LinkedHashMap<>();

        for (int i = 0; i < n ; i++) {
            String[]commands = scanner.nextLine().split("\\s+");
            String command= commands[0];
            String userName = commands[1];

            switch (command){

                case "register":
                    String carNumber = commands[2];

                    if (!people.containsKey(userName)){
                        people.put(userName, carNumber);
                        System.out.printf("%s registered %s successfully%n",userName, carNumber);
                    }else {
                        System.out.printf("ERROR: already registered with plate number %s%n", people.get(userName));
                    }
                    break;
                case "unregister":
                    if (!people.containsKey(userName)){
                        System.out.printf("ERROR: user %s not found%n",userName);
                    }else{
                        people.remove(userName);
                        System.out.printf("%s unregistered successfully%n",userName);
                    }
                    break;
            }
        }
        people.entrySet()
                .stream()
                .forEach(e -> System.out.printf("%s => %s%n",e.getKey(), e.getValue()));
    }
}