import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> VIP = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")){

            if (Character.isDigit(input.charAt(0))){
                VIP.add(input);
            }else {
                regularGuests.add(input);
            }
            input = scanner.nextLine();
        }
        while (!input.equals("END")){
            if (Character.isDigit(input.charAt(0))){
                VIP.remove(input);
            }else {
                regularGuests.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(VIP.size() + regularGuests.size());
        VIP.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }
}
