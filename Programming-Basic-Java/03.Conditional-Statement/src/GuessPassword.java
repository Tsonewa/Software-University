import java.util.Scanner;

public class GuessPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (password.equals("s3cr3t!P@ssw0rd")) {
            System.out.print("Welcome");
        }else {
            System.out.print("Wrong password!");
        }
        }
    }