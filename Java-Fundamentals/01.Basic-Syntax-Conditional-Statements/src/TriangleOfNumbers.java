import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int digit = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= digit ; i++) {
            System.out.println();
            for (int j = 0; j < i ; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
