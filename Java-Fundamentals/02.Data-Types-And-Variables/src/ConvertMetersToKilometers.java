import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        int meter = Integer.parseInt(scanner.nextLine());
        double meterInt = meter;
        double kilometers = meterInt / 1000;
        System.out.printf("%.2f", kilometers);
    }
}
