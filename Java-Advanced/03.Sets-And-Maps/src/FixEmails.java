import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> emails = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine().toLowerCase();
            if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {
                name = scanner.nextLine();
            } else {
                emails.putIfAbsent(name, email);
                name = scanner.nextLine();
            }
        }
        emails.entrySet().stream()
                .forEach(entry -> System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue())));
        }
    }
