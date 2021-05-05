import java.util.Scanner;

public class FromHundredToTwoHundred {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        if (number < 100){
            System.out.print("Less than 100");
        }else if (number > 200){
            System.out.print("Greater than 200");
        }else {
            System.out.print("Between 100 and 200");
        }
        }
    }