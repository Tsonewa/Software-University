import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FillterByAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            people.put(tokens[0], Integer.parseInt(tokens[1]));
        }

        String condition = scanner.nextLine();
        int border = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> checkAge = checkAge(condition, border);
        String model = scanner.nextLine();
        Consumer<Map.Entry<String, Integer>> print = printConsumer(model);

        finalPrint(people, checkAge, print);

    }
    private static void finalPrint (
            LinkedHashMap<String, Integer> people,
            Predicate<Integer> checkAge,
            Consumer<Map.Entry<String, Integer>> print){

        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (checkAge.test(entry.getValue())) {
                print.accept(entry);
            }
        }
    }
    private static Consumer<Map.Entry<String, Integer>> printConsumer(String model) {
        Consumer<Map.Entry<String, Integer>> entryConsumer = null;

        switch (model) {
            case "name":
                entryConsumer =  entry -> System.out.printf("%s%n", entry.getKey());
                break;
            case "age":
                entryConsumer = entry -> System.out.printf("%d%n", entry.getValue());
                break;
            case "name age":
                entryConsumer = entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                break;
        }
        return entryConsumer;
    }
    private static Predicate<Integer> checkAge(String condition, int border){
        if (condition.equals("younger")) {
            return e -> e <= border;
        }
        return e -> e >= border;
    }
}
