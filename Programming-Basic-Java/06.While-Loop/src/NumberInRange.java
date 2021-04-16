import java.util.Scanner;

public class NumberInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int input = Integer.parseInt(scanner.nextLine());
        while(input < 1 || input > 100){
            System.out.println("Invalid number!");
            input = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("The number is: %d",input);
    }
}
