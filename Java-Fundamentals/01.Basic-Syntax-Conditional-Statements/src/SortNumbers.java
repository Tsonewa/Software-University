import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
// 2, 1, 3 == 3, 2, 1

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberOThree = Integer.parseInt(scanner.nextLine());
        int firstNumber = 0;
        int secondNumber= 0;
        int thirdNumber = 0;


        if (numberOne > numberTwo && numberOne > numberOThree){
            firstNumber = numberOne;
        }else if (numberOne < numberTwo && numberOne < numberOThree){
            thirdNumber = numberOne;
        }else {
            secondNumber = numberOne;
        }
        if (numberTwo >= numberOne && numberTwo >= numberOThree){
            firstNumber = numberTwo;
        }else if (numberTwo <= numberOne && numberTwo <= numberOThree){
            thirdNumber = numberTwo;
        }else {
            secondNumber = numberTwo;
        }
        if (numberOThree >= numberOne && numberOThree >= numberTwo){
            firstNumber = numberOThree;
        }else if (numberOThree <= numberOne && numberOThree <= numberTwo){
            thirdNumber = numberOThree;
        }else {
            secondNumber = numberOThree;
        }
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(thirdNumber);
    }
}