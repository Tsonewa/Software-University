import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int input = Integer.parseInt(scanner.nextLine());
        for (int i = 97; i < 97 + input; i++) {
            char first = (char)i;
            for (int j = 97; j < 97 + input ; j++) {
                char second = (char) j;
                for (int k = 97; k < 97 + input ; k++) {
                    char third = (char) k;
                    System.out.printf("%c%c%c\n", first, second, third);
                }
            }
        }
    }
}
