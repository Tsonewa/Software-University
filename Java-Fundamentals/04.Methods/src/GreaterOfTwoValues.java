import java.util.Scanner;

public class GreaterOfTwoValues {
    public static int getMax(int firstNumber, int secondNumber){
        int maxNumber = 0;
        if (firstNumber > secondNumber) {
            maxNumber += firstNumber;
        }else {
            maxNumber += secondNumber;
        }
        return maxNumber;
    }

    public static char getMax (char firstChar,char secondChar){
        char maxChar = 0;
        if (firstChar > secondChar){
            maxChar += firstChar;
        }else {
            maxChar += secondChar;
        }
        return maxChar;

    }

    public static String getMax(String firstString,String secondString){
        if (firstString.compareTo(secondString) >= 0){
            return firstString;
        }else {
            return secondString;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        You are given two values of the same type as input. The values can be of type int, char of String.
        Create a method getMax() that returns the greater of the two values:
         */
        String input = scanner.nextLine();
        switch (input){
            case "int" :
                int firstNumber = Integer.parseInt(scanner.nextLine());
                int secondNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNumber,secondNumber));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstChar, secondChar));
                break;
            case "string" :
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(getMax(firstString, secondString));
                break;
        }
    }
}