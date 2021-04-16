import java.util.Scanner;

public class CharactersInRange {

    public static void rangeChars(char start, char end) {
        for (int i = start + 1; i < end; i++) {
            System.out.printf("%c ", i);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        if (start > end) {
            rangeChars(end, start);
        }else{
            rangeChars(start, end);
        }
    }
}