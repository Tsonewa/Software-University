import java.util.Scanner;

public class AddAndSubtract {
    public static int numbersSum (int a, int b){
        return a + b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        numbersSum(a, b);
        System.out.println(numbersSum(a, b) - c);
    }
}