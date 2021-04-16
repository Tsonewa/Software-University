import java.util.Scanner;

public class Travelling {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String destination = scanner.nextLine();

        while (!"End".equalsIgnoreCase(destination)) {
            double budget = Double.parseDouble(scanner.nextLine());
            double saveMoney = 0;
           while (saveMoney < budget){
               saveMoney += Double.parseDouble(scanner.nextLine());
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}
