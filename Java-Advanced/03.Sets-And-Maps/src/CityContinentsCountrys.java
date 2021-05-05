import java.util.*;

public class CityContinentsCountrys {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            data.get(continent).putIfAbsent(country, new ArrayList<>());
            data.get(continent).get(country).add(city);

        }
        data.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue().entrySet().stream()
                            .forEach(innerEntry -> {
                                System.out.print("  " + innerEntry.getKey() + " -> ");
                                System.out.println(String.join(", ", innerEntry.getValue()));
                            });
                });
    }
}

