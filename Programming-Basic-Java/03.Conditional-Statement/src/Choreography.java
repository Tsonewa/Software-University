import java.util.Scanner;

public class Choreography {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double steps = Double.parseDouble(scanner.nextLine());
        double dancers = Double.parseDouble(scanner.nextLine());
        double days = Double.parseDouble(scanner.nextLine());

        double percentSteps = (steps / days) / steps;
        double total = percentSteps * 100;
        double stepsTotal = Math.ceil(total);
        double stepsPerDancer = stepsTotal / dancers;
        String percent = "%";

        if (stepsTotal <= 13) {
            System.out.printf("Yes, they will succeed in that goal! %.2f%s.%n",stepsPerDancer,percent);
        }else {
            System.out.printf("No, they will not succeed in that goal! Required %.2f%s steps to be learned per day.",stepsPerDancer, percent);
        }
    }
}
