import java.util.Scanner;

public class SchoolSupplies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int packetPen = Integer.parseInt(scanner.nextLine());
        int packetMarker = Integer.parseInt(scanner.nextLine());
        double cleanWater = Double.parseDouble(scanner.nextLine());
        int purcentDiscount = Integer.parseInt(scanner.nextLine());

        //•	Пакет химикали - 5.80 лв
        //•	Пакет маркери - 7.20 лв
        //•	Препарат - 1.20 лв (за литър)
        double pricePen = packetPen * 5.8;
        double priceMarker = packetMarker * 7.2;
        double priceWater = cleanWater * 1.2;

        double priceAll = priceMarker + pricePen + priceWater;
        double discount = priceAll - ((priceAll * purcentDiscount) / 100);

        System.out.printf("%.3f", discount);
    }
}
