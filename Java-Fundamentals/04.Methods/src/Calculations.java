import java.util.Scanner;

public class Calculations {

    public static void addNumbers(int firstNumber, int secondNumber){
        int addOfNumbers = firstNumber + secondNumber;
        System.out.print(addOfNumbers);
    }

    public static void multiplyNumbers(int firstNumber, int secondNumber) {
        int multiplyOfNumbers = firstNumber * secondNumber;
        System.out.print(multiplyOfNumbers);
    }
    public static void substractNumbers(int firstNumber, int secondNumber) {
        int substractOfNumbers = firstNumber - secondNumber;
        System.out.print(substractOfNumbers);
    }
    public static void divideNumbers(int firstNumber, int secondNumber) {
        int divideOfNumbers = firstNumber / secondNumber;
        System.out.print(divideOfNumbers);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Write a program that receives a string on the first line
        add /multiply/subtract/ divide
         and on the next two lines receives two numbers. Create four methods (for each calculation)
         and invoke the right one depending on the command. The method should also print the result (needs to be void).
         */
        String operation = scanner.nextLine();
        int firstNumber= Integer.parseInt(scanner.nextLine());
        int secondNumber= Integer.parseInt(scanner.nextLine());
        switch (operation){
            case "add":
                addNumbers(firstNumber, secondNumber);
                break;
            case "multiply" :
                multiplyNumbers(firstNumber, secondNumber);
                break;
            case "subtract":
                substractNumbers(firstNumber, secondNumber);
                break;
            case "divide":
                divideNumbers(firstNumber, secondNumber);
                break;
        }
    }
}