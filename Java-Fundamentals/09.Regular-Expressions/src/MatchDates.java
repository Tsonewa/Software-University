import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b(?<day>\\d{2})([\\/.-])(?<month>[A-Z]{1}[a-z]{2})\\2(?<year>\\d{4})\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher compere = pattern.matcher(input);

        while (compere.find()){

            String date = compere.group("day");
            String months = compere.group("month");
            String years = compere.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", date, months, years);
        }
    }
}