import java.util.Scanner;

public class ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String input = scanner.nextLine();
        int countAdult = 0;
        int countKids = 0;
        int coundMoneyToys = 0;
        int countMoneySweaters= 0;

        while (!input.equals("Christmas")){
            int years = Integer.parseInt(input);
            if (years <= 16){
                countKids++;
                coundMoneyToys += 5;
            }else {
                countAdult++;
                countMoneySweaters += 15;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Number of adults: %d%n",countAdult);
        System.out.printf("Number of kids: %d%n", countKids);
        System.out.printf("Money for toys: %d%n",coundMoneyToys);
        System.out.printf("Money for sweaters: %d",countMoneySweaters);
    }
}
