import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> table = new TreeSet<>();

        for (int i = 0; i < n ; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            Collections.addAll(table, elements);
        }

        table.stream().forEach(e -> System.out.print(e + " ") );
    }
}
