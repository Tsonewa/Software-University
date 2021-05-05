import java.util.LinkedHashMap;
import java.util.Scanner;

public class ReverseStrings {
    public static String reverseString (String input) {

        StringBuilder reversedInput = new StringBuilder();
        reversedInput.append(input);

        reversedInput = reversedInput.reverse();
        String result = reversedInput.toString();

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> passwords = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while(!input.equals("end")){

            reverseString(input);
            passwords.putIfAbsent(input, reverseString(input));

            input= scanner.nextLine();
        }
        passwords
                .entrySet()
                .forEach(entry -> System.out.printf("%s = %s%n", entry.getKey(), entry.getValue()));
    }
}