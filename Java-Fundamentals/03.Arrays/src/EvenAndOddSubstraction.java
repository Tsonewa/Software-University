import java.util.Scanner;

public class EvenAndOddSubstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        String input = scanner.nextLine();
        String[] letter = input.split(" ");
        int[] digit = new int[letter.length];

        for (int i = 0; i < digit.length; i++) {
            digit[i] = Integer.parseInt(letter[i]);
        }
        int even = 0;
        int odd = 0;
        for (int i = 0; i < digit.length; i++) {
            int currNumber = digit[i];
            if (currNumber % 2 == 0){
                even += currNumber;
            }else {
                odd += currNumber;
            }
        }
        int result = even - odd;
        System.out.println(result);
    }
}
