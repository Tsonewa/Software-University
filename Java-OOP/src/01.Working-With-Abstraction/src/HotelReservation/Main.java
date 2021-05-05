package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        PriceCalculator priceCalculator = new PriceCalculator(Double.parseDouble(input[0]),
                Integer.parseInt(input[1]), Seasons.valueOf(input[2].toUpperCase()), Discount.valueOf(input[3].toUpperCase()));
        System.out.printf("%.2f", priceCalculator.getPrice());
    }
    }