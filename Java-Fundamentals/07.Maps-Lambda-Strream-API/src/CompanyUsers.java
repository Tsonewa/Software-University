import java.util.*;
import java.util.stream.Collectors;

public class CompanyUsers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, ArrayList<String>> companies = new LinkedHashMap<>();

        while(!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String employeeId = tokens[1];
            if (companies.containsKey(companyName) && companies.get(companyName).contains(employeeId)) {
                input = scanner.nextLine();
                continue;
            }
            if (!companies.containsKey(companyName)){
                companies.putIfAbsent(companyName, new ArrayList<>());
                companies.get(companyName).add(employeeId);
            }else if (companies.containsKey(companyName) && !companies.get(companyName).contains(employeeId)) {
                companies.get(companyName).add(employeeId);
            }
            input = scanner.nextLine();
        }
        companies.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.printf("%s%n", e.getKey());

                    e.getValue().stream()
                            .forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}