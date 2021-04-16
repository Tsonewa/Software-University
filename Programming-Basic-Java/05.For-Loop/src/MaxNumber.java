import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    int mN = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++){
        int currentNumber = Integer.parseInt(scanner.nextLine());
        if (currentNumber > mN){
            mN = currentNumber;
        }
    }
    System.out.println(mN);
}
}
