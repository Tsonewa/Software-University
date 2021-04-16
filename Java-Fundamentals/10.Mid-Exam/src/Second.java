import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Second {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "(\\*|:){2}(?<emojis>[A-Z][a-z]{2,})(\\1){2}";
        String numReg = "[0-9]";
        Pattern pattern = Pattern.compile(regex);
        Pattern sec = Pattern.compile(numReg);

        String input = scanner.nextLine();
        Matcher coolValid = sec.matcher(input);
        Matcher isValid = pattern.matcher(input);
        ArrayList<String> emojies = new ArrayList<>();
        int cool = 1;
        int countEm = 0;

        while (coolValid.find()) {
            int coolnes = Integer.parseInt(coolValid.group());
            cool = coolnes * cool;
        }

        while (isValid.find()) {
            String emoji = isValid.group();
            countEm++;
            int sumChar = 0;
            for (int i = 2; i < emoji.length() - 2; i++) {
                int symbol = emoji.charAt(i);
                sumChar += symbol;
            }
            if (sumChar > cool) {
                emojies.add(emoji);
            }
        }

        System.out.printf("Cool threshold: %d%n", cool);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countEm);
        for (String em : emojies) {
            System.out.println(em);
        }

    }
}