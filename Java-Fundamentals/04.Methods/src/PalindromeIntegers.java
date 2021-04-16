import java.util.Scanner;

public class PalindromeIntegers {

    public static StringBuilder readLineBackward(String number) {
        StringBuilder resultBackwords = new StringBuilder();
        resultBackwords.append(number);
        resultBackwords = resultBackwords.reverse();

        return resultBackwords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        boolean result = false;

        while (!number.equals("END")){
            if (number.contentEquals(readLineBackward(number))){
                result = true;
            }
            System.out.println(result);
            number = scanner.nextLine();
            result = false;
        }
    }
}
