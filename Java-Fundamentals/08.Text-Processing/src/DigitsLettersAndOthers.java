import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder chars = new StringBuilder();

        for (int i = 0; i < input.length() ; i++) {

            if (Character.isDigit(input.charAt(i))){
                digits.append(input.charAt(i));
            }else if(Character.isAlphabetic(input.charAt(i))){
                letters.append(input.charAt(i));
            }else {
                chars.append(input.charAt(i));
            }
        }
        System.out.printf("%s%n", digits);
        System.out.printf("%s%n", letters);
        System.out.printf("%s%n", chars);
    }
}
