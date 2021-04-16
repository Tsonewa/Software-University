import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        char baseLetter = text.charAt(0);
        result.append(baseLetter);
        for (int i = 1; i < text.length() ; i++) {
            char secondSymbol = text.charAt(i);
            if (baseLetter != secondSymbol){
                result.append(secondSymbol);
                baseLetter = secondSymbol;
            }
        }
        System.out.println(result);
    }
}