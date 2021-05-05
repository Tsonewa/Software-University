import java.util.Scanner;

public class SignOfIntegerNumbers {


    public static void printNumber(int number){
        if (number > 0){
            System.out.printf("The number %d is positive.", number);
        } else if(number < 0){
            System.out.printf("The number %d is negative.", number);
        }else {
            System.out.print("The number 0 is zero.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int number = Integer.parseInt(scanner.nextLine());
        printNumber(number);
    }
}
