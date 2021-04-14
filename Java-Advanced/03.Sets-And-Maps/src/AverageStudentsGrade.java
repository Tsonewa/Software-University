import java.util.*;
import java.util.stream.Stream;

public class AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> students = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(input[0], new ArrayList<>());
            students.get(student).add(grade);
        }
            students.entrySet()
                    .forEach(entry -> {
                        double sum = 0;
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            sum += entry.getValue().get(i);
                        }
                        double avgSum = sum / entry.getValue().size();

                        System.out.print(entry.getKey() + " -> ");
                        entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                        System.out.printf("(avg: %.2f)%n", avgSum);
                    });
    }

}
