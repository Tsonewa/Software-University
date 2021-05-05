import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double change = Double.parseDouble(scanner.nextLine());
        change = Math.floor(change * 100);
        int coin = 0;

        while (change > 0) {
            if (change >= 200) {
                coin++;
                change -= 200;
            }else  if (change >= 100) {
                coin++;
                change -= 100;
            }else  if (change >= 50) {
                coin++;
                change -= 50;
            }else  if (change >= 20) {
                coin++;
                change -= 20;
            }else  if (change >= 10) {
                coin++;
                change -= 10;
            }else  if (change >= 5) {
                coin++;
                change -= 5;
            }else  if (change >= 2) {
                coin++;
                change -= 2;
            }else  if (change >= 1) {
                coin++;
                change -= 1;
            }
        }
        System.out.println(coin);
    }

}
