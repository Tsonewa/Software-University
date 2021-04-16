import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int point = Integer.parseInt(scanner.nextLine());
        double bonus = 0;
        if (point <= 100) {
            bonus = 5;
        } else if (point <= 1000) {
            bonus = 0.2 * point;
        } else {
            bonus = 0.1 * point;
        }
        if (point % 2 == 0) {
            bonus += 1;
        } else if (point % 10 == 5) {
            bonus += 2;
        }
        System.out.println(bonus);
        System.out.println(point + bonus);
    }
}
