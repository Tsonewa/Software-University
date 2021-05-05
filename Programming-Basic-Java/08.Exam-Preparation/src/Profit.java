import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int coinLev = Integer.parseInt(scanner.nextLine());
        int coinDva = Integer.parseInt(scanner.nextLine());
        int billFive = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= coinLev ; i++) {
            for (int j = 0; j <= coinDva ; j++) {
                for (int k = 0; k <= billFive; k++) {
                    if (i +  j * 2 + k * 5 == sum){
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n",i,j,k,sum);
                    }

                }

            }

        }
    }
}
