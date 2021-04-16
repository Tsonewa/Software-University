import java.util.Scanner;

public class UnicpinCode {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //input
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= first; i++) {
            for (int j = 1; j <= second; j++) {
                for (int k = 1; k <= third; k++) {
                    if (i % 2 == 0 && k % 2 == 0) {
                        if (j == 2 || j == 3 || j == 5 || j == 7) {
                            System.out.println(i + " " + j + " " + k);
                        }

                    }
                }

            }
        }
    }
}