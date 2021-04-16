import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double spendMoney = 0;
        List<String> boughtFurnitures = new ArrayList<>();

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]+)!(?<quantity>[0-9]+)";

        while (!input.equals("Purchase")) {

            Pattern compare = Pattern.compile(regex);
            Matcher matcher = compare.matcher(input);

            while (matcher.find()) {
                String furniture = matcher.group("furniture");
                boughtFurnitures.add(furniture);

                double a = Double.parseDouble(matcher.group("price"));
                int qualtity = Integer.parseInt(matcher.group("quantity"));
                double sum = a * qualtity;
                spendMoney += sum;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String a : boughtFurnitures
        ) {
            System.out.println(a);
        }
        System.out.printf("Total money spend: %.2f", spendMoney);
    }
}