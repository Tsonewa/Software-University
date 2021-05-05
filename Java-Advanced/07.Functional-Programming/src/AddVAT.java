import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatAdd = e -> e * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(e -> vatAdd.apply(Double.parseDouble(e)))
                .boxed()
                .collect(Collectors.toList())
                .forEach(e -> {
                    System.out.printf("%.2f%n", e);
                });
    }
}
