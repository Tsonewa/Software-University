import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        String firstPassword = scanner.nextLine();
        int countTomes = 0;
        boolean check = false;
        while (!password.equals(firstPassword)) {
            countTomes++;
            if (countTomes == 4) {
                System.out.printf("User %s blocked!", username);
                check = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            firstPassword = scanner.nextLine();
        }
        if (!check) {
            System.out.printf("User %s logged in.", username);
        }
    }
}