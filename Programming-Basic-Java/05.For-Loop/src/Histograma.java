import java.util.Scanner;

public class Histograma {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        for (int i = 0; i < n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 200){
                count1++;
            }else if (number <= 399){
                count2++;
            }else if (number <= 599){
                count3++;
            }else if (number <= 799){
                count4++;
            } else{
                count5++;
            }

        }
        double percentCount1 = (count1 * 1.0 / n) * 100;
        double percentCount2 = (count2 * 1.0 / n) * 100;
        double percentCount3 = (count3 * 1.0 / n) * 100;
        double percentCount4 = (count4 * 1.0 / n) * 100;
        double percentCount5 = (count5 * 1.0 / n) * 100;

        System.out.printf("%.2f%%%n", percentCount1);
        System.out.printf("%.2f%%%n", percentCount2);
        System.out.printf("%.2f%%%n", percentCount3);
        System.out.printf("%.2f%%%n", percentCount4);
        System.out.printf("%.2f%%%n", percentCount5);
}
}