import java.util.Scanner;

public class Passed {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 3){
            System.out.println("Passed!");
        }
    }
}

