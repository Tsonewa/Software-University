import java.util.Scanner;

public class AccoundNumber {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
       int countPayment = Integer.parseInt(scanner.nextLine());
       double sum = 0;
       double countTransaction = 0;

       while (countTransaction < countPayment ) {
           double fee = Double.parseDouble(scanner.nextLine());
           if (fee < 0) {
               System.out.println("Invalid operation!");
               break;
           }
           System.out.printf("Increase: %.2f%n", fee);
           sum += fee;
           countTransaction++;
       }
        System.out.printf("Total: %.2f", sum);
    }
}
