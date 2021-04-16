import java.util.*;
import java.util.stream.Collectors;

public class StudentAcademy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<Double>> students = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(student, new ArrayList<>());
            students.get(student).add(grade);

        }
        students.entrySet()
                .stream()
                .filter(e -> e.getValue().stream().mapToDouble(d -> Double.valueOf(d)).average().getAsDouble() >= 4.50)
                .sorted((s1,s2) -> {
                    double first = s1.getValue().stream().mapToDouble(d -> Double.valueOf(d)).average().getAsDouble();
                    double second = s2.getValue().stream().mapToDouble(d -> Double.valueOf(d)).average().getAsDouble();
                    return Double.compare(second, first);
                })
                .forEach(st -> System.out.printf("%s -> %.2f%n", st.getKey(), st.getValue().stream().mapToDouble(d -> Double.valueOf(d)).average().getAsDouble()));
    }
}