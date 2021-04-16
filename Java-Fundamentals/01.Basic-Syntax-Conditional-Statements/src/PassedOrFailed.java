import java.util.Scanner;

public class PassedOrFailed {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 3.00){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }
    }
}
