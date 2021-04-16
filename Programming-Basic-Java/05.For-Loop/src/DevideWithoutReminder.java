import java.util.Scanner;

public class DevideWithoutReminder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        int countDivide2 = 0;
        int countDivide3 = 0;
        int countDivide4 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number % 2 == 0) {
                countDivide2++;
            }
            if (number % 3 == 0) {
                countDivide3++;
            }
            if (number % 4 == 0){
                countDivide4++;
            }
        }
        double percentDivide2 = (countDivide2 * 1.0 / n) * 100;
        double percentDivide3 = (countDivide3 * 1.0 / n) * 100;
        double percentDivide4 = (countDivide4 * 1.0 / n) * 100;

        System.out.printf("%.2f%%%n", percentDivide2);
        System.out.printf("%.2f%%%n", percentDivide3);
        System.out.printf("%.2f%%%n", percentDivide4);
    }
}