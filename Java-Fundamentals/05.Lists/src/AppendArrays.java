import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");

        List<String> result = new ArrayList<>();
        for (int i = input.length - 1; i >= 0 ; i--) {
            String[] arr = input[i].trim().split("\\s+");
            for (String symbol: arr) {
                result.add(symbol);
            }
            result.remove("");
        }
        for (String number: result) {
            System.out.print(number + " ");
        }
    }
}
