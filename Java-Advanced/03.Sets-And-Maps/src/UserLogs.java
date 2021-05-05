import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Map<String,Integer>> data = new TreeMap<>();

        String input =scanner.nextLine();

        while (!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String[] ipAdress = tokens[0].split("=");
            String IP = ipAdress[1];
            String[] tokensMassage = tokens[1].split("=");
            String message = tokensMassage[1];
            String[] getUsrname = tokens[2].split("=");
            String user = getUsrname[1];

            if (isValid(message)){
            data.putIfAbsent(user, new LinkedHashMap<>());
            data.get(user).putIfAbsent(IP, 0);
            data.get(user).put(IP, data.get(user).get(IP) + 1);
            }
            input = scanner.nextLine();
        }
        data.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    int[] counter = {0};
                    entry.getValue().entrySet()
                            .forEach(entry1 -> {

                                if (counter[0] < entry.getValue().size() - 1) {
                                    System.out.printf("%s => %d, ", entry1.getKey(), entry1.getValue());
                                } else {
                                    System.out.printf("%s => %d.%n", entry1.getKey(), entry1.getValue());
                                }
                            counter[0]++;
                            });
                });
    }

    private static boolean isValid(String message) {
        return  message.contains("'");
    }
}
