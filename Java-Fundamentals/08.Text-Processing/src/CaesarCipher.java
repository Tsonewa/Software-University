import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String criptPass = "";

        for (int i = 0; i < text.length() ; i++) {
            char letter =(char) (text.charAt(i) + 3);
            criptPass += letter;
        }
        System.out.print(criptPass);
    }
}
