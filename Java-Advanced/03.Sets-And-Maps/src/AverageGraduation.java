import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AverageGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).addAll(grades);
        }

        students.entrySet().stream()
                .forEach(entry -> {
                    double sum = 0;

                    for (int i = 0; i < entry.getValue().size() ; i++) {
                        sum += entry.getValue().get(i);
                    }
                    double average = sum / entry.getValue().size();
                    String s = new DecimalFormat("0.#######").format(average);
                    System.out.printf("%s is graduated with %s%n", entry.getKey(), s);
                });
    }
}
