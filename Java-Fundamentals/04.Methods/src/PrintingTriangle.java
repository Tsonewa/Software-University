import java.util.Scanner;

public class PrintingTriangle {

    public  static void printPositive(int input){
        for (int i = 1; i <= input ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        int input = Integer.parseInt(scanner.nextLine());

        for (int d = 0; d < input ; d++) {
            printPositive(d + 1);
        }
        for (int f = input - 1; f > 0; f--) {
            printPositive(f);

        }
    }
}
