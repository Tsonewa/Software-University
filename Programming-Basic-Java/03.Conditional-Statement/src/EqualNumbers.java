import java.util.Scanner;

public class EqualNumbers {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());

        if (a != b) {
            System.out.println("no");
        }else if (b != c){
            System.out.println("no");
        }else {
            System.out.println("yes");
        }
        }
    }

