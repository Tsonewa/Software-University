import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        int number = Integer.parseInt(scanner.nextLine());
        if(!((number >= 100 && number <= 200) || number == 0)){
            System.out.println("invalid");
        }
    }
}