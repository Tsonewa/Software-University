import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] passwords = scanner.nextLine().split(", ");

        for (String password : passwords) {
            if ((isValid(password))) {
                System.out.println(password);
            }
        }
    }
    public static boolean isValid(String password) {

        if (password.length() < 3 || password.length() > 16) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);

            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }

}
