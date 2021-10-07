import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt((scanner.nextLine()));

            printTop(n);
            printBottom(n);

        }

    public static void printTop(int count){
        for (int i = 1; i <= count ; i++) {
            for (int k = 0; k < count - i ; k++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        }
        public static void printBottom(int count){
            for (int i = count - 1; i >= 0 ; i--) {
                for (int k = 1; k <= count - i; k++) {
                    System.out.print(" ");
                }

                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
