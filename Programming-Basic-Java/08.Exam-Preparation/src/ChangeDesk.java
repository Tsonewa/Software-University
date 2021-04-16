import java.util.Scanner;

public class ChangeDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int bitCoin = Integer.parseInt(scanner.nextLine());
        double chineseUn = Double.parseDouble(scanner.nextLine());
        double comision = Double.parseDouble(scanner.nextLine());

        int sumBitCoin = bitCoin * 1168;
        double unInDolar = chineseUn * 0.15;
        double dolarImLeva = unInDolar * 1.76;

        double sumLeva = dolarImLeva + sumBitCoin;
        double euro = sumLeva / 1.95;

        double total = (euro * comision) / 100;

        double sum = euro - total;
        System.out.printf("%.2f", sum);
    }
}
