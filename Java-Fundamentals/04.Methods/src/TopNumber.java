import java.util.Scanner;

public class TopNumber {
    public static boolean checkForOdd (int n){
        int count = 0;

        while (n > 0){
            if ((n % 10) % 2 == 1) {
                count++;
            }
            n = n / 10;
        }
        if (count >= 1){
            return true;
        }
        return false;
    }

    public static boolean checkSum (int n){
        int sum = 0;

        while (n > 0){
            sum += n % 10;
            n = n / 10;
        }
        if (sum % 8 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (checkForOdd(i) && checkSum(i)){
                System.out.println(i);
            }
        }
    }
}