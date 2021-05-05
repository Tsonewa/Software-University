import java.util.Scanner;

public class PasswordValidator {
    public static boolean checkLength(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            count++;
        }
        if (count < 6 || count > 10) {
            return true;
        }
        return false;
    }

    public static boolean checkCharecters(String password) {
        for (int i = 0; i < password.length(); i++) {
            int symbol = password.charAt(i);
            if ((symbol >= 0 && symbol <= 47) || (symbol >= 58 && symbol < 65) ||
                    (symbol >= 91 && symbol <= 96) || (symbol >= 123 && symbol <= 255)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNumberofDigits(String password) {
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            int symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57) {
                digitCount++;
            }
        }
        if (digitCount < 2) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        checkCharecters(password);
        checkLength(password);
        checkNumberofDigits(password);
        if (checkCharecters(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (checkLength(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (checkNumberofDigits(password)){
            System.out.println("Password must have at least 2 digits");
        }
        if (!checkCharecters(password) && !checkNumberofDigits(password) &&
                !checkLength(password)){
            System.out.println("Password is valid");
        }
    }
}
