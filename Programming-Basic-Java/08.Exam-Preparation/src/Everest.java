import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String sleepOrNo = scanner.nextLine();
        int countMeter = 5364;
        int countDays = 1;

        while (!sleepOrNo.equals("END")) {
            int climbedMeter = Integer.parseInt(scanner.nextLine());
            if (sleepOrNo.equals("Yes")) {
                countMeter += climbedMeter;
                countDays++;
            } else if (sleepOrNo.equals("No")) {
                countMeter += climbedMeter;
            }
            if (countDays >= 5) {
                System.out.println("Failed!");
                System.out.printf("%d", countMeter);
                break;
            }
            if (countMeter > 8848) {
                System.out.printf("Goal reached for %d days!", countDays);
                break;
            }
            sleepOrNo = scanner.nextLine();
        }
        if (countMeter <= 8848 && countDays < 5) {
            System.out.println("Failed!");
            System.out.printf("%d", countMeter);
        }
    }
}
