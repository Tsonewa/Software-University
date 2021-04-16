import java.util.Scanner;

public class EqualWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();
        firstWord = firstWord.toUpperCase();
        secondWord = secondWord.toUpperCase();

        if (firstWord.equals(secondWord)){
            System.out.print("yes");
        }else {
            System.out.print("no");
        }
        }

    }
