package CountGenerics;

import java.util.Scanner;

public class Main {
    public static void  main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        BoxCount<Double> boxCount = new BoxCount<>();
        for (int i = 0; i < n; i++) {
            double lines = Double.parseDouble(scanner.nextLine());
            boxCount.add(lines);
        }
        double number = Double.parseDouble(scanner.nextLine());
        long count = boxCount.countGreaterString(number);
        System.out.println(count);
    }
}
