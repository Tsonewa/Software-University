import java.util.Scanner;

public class RepeatString {
    public static String repeatedString(String input, int repeatTimes) {
        String result = "";
        for (int i = 0; i < repeatTimes; i++) {
            result += input;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Write a method that receives a string and a repeat count n (integer).
        The method should return a new string (the old one repeated n times).
         */
        String input = scanner.nextLine();
        int repeatTimes = Integer.parseInt(scanner.nextLine());
        System.out.println(repeatedString(input, repeatTimes));
    }
}
