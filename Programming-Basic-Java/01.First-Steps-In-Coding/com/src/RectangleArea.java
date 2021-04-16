import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double area = a * b;
        System.out.println(area);
    }
}