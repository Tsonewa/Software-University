import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String sum = "";
        for (int i = 0; i < 3; i++) {
            char symbol = scanner.nextLine().charAt(0);
            sum += symbol;
        }
        System.out.print(sum);
    }
}
