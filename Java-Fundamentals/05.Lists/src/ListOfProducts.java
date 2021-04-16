import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfproduct = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < numberOfproduct ; i++) {
            String product = scanner.nextLine();
            names.add(product);
        }
        Collections.sort(names);
        for (int i = 0; i < numberOfproduct ; i++) {
            System.out.printf("%d.%s%n", i + 1, names.get(i));
        }

    }
}