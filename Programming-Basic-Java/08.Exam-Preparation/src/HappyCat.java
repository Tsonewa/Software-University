import java.util.Scanner;

public class HappyCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int numberDays = Integer.parseInt(scanner.nextLine());
        int numberHoursPerDay = Integer.parseInt(scanner.nextLine());
        double allFee = 0;

        for (int i = 1; i <= numberDays; i++) {
            double countDayPrice = 0;
            for (int j = 1; j <= numberHoursPerDay; j++) {
                if (i % 2 == 0 && j % 2 == 1) {
                    countDayPrice += 2.50;
                    allFee += 2.50;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    countDayPrice += 1.25;
                    allFee += 1.25;
                } else {
                    countDayPrice += 1;
                    allFee += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n", i, countDayPrice);
            if (i == numberDays) {
                System.out.printf("Total: %.2f leva", allFee);
            }
        }
    }
}
