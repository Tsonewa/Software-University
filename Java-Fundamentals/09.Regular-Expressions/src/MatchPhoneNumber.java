import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\+359([\\- ])2(\\1)\\d{3}(\\1)[0-9]{4}\\b";
        String input = scanner.nextLine();
        List<String> phones = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher compare = pattern.matcher(input);

        while(compare.find()){
            phones.add(compare.group());
        }
        System.out.println(String.join(", ", phones));
    }
}