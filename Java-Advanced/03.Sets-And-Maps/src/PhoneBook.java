import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String contacts = scanner.nextLine();
        HashMap<String,String> phoneBook = new HashMap<>();

        while(!contacts.equals("search")){
            String[] tokens = contacts.split("-");

            phoneBook.put(tokens[0], tokens[1]);
            contacts =scanner.nextLine();
        }
        String search = scanner.nextLine();

        while (!search.equals("stop")){
            if (phoneBook.containsKey(search)){
                System.out.printf("%s -> %s%n", search, phoneBook.get(search));
            }else {
                System.out.printf("Contact %s does not exist.%n", search);
            }
            search = scanner.nextLine();
        }
    }
}
