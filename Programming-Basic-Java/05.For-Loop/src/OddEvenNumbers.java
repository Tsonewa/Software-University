import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        double sumEven = 0;
        double minEven = 1000000000.0;
        double maxEven = -1000000000.0;

        double sumOdd = 0;
        double minOdd = 1000000000.0;
        double maxOdd = -1000000000.0;

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) {
                sumEven += number;

            if (number < minEven) {
                minEven = number;
            }
            if (number > maxEven) {
                maxEven = number;
            }
            } else {
                sumOdd += number;

                if (number < minOdd) {
                    minOdd = number;
                }
                if (number > maxOdd) {
                    maxOdd = number;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n",sumOdd);
        if (minOdd == 1000000000.0) {
            System.out.println("OddMin=No,");
        } else {
            System.out.printf("OddMin=%.2f,%n",minOdd);
        }
        if (maxOdd == -1000000000.0){
            System.out.println("OddMax=No,");
        } else {
            System.out.printf("OddMax=%.2f,%n",maxOdd);
        }
        System.out.printf("EvenSum=%.2f,%n",sumEven);
        if (minEven == 1000000000.0) {
            System.out.println("EvenMin=No,");
        } else {
            System.out.printf("EvenMin=%.2f,%n",minEven);
        }
        if (maxEven == -1000000000.0){
            System.out.println("EvenMax=No");
        } else {
            System.out.printf("EvenMax=%.2f%n",maxEven);
        }

        }
    }
