import java.util.Scanner;

public class ExamCleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double ring = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int toyCount = 0;
        int moneyCount = 0;
        int totalMoney = 0;

        for (int i = 1; i <= age ; i++) {
            if (i % 2 == 0){
                moneyCount++;
                totalMoney += moneyCount * 10;
            }else {
                toyCount++;
            }
        }
        int toysPrice = toyCount * toyPrice;
        int result = (toysPrice + totalMoney) - moneyCount;

        if (result >= ring) {
            System.out.printf("Yes! %.2f", result - ring);
        }else {
            System.out.printf("No! %.2f", ring - result);
        }
    }
}
