import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String input = scanner.nextLine();

        for (int i = input.length() - 1; i >= 0 ; i--) {
            char letter = input.charAt(i);

            System.out.print(letter);
        }


    }
}