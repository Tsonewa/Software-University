import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double studioNights = 0;
        double apartmentNights = 0;
        //night
        switch (month) {
            case "May":
                studioNights = 50 * nights;
                apartmentNights = 65 * nights;
                if (nights > 14) {
                    double apartmentDiscount = apartmentNights - (apartmentNights * 0.1);
                    System.out.printf("Apartment: %.2f lv.%n", apartmentDiscount);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", apartmentNights);
                }
                if (nights > 14) {
                    double studioDiscount = studioNights - (studioNights * 0.30);
                    System.out.printf("Studio: %.2f lv.", studioDiscount);
                } else if (nights > 7) {
                    double studioDiscount = studioNights - (studioNights * 0.05);
                    System.out.printf("Studio: %.2f lv.", studioDiscount);
                } else {
                    System.out.printf("Studio: %.2f lv.", studioNights);
                }
                break;
            case "June":
                studioNights = 75.20 * nights;
                apartmentNights = 68.70 * nights;
                if (nights > 14) {
                    double apartmentDiscount = apartmentNights - (apartmentNights * 0.1);
                    System.out.printf("Apartment: %.2f lv.%n.", apartmentDiscount);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n.", apartmentNights);
                }
                if (nights > 14) {
                    double studioDiscount = studioNights - (studioNights * 0.20);
                    System.out.printf("Studio: %.2f lv.", studioDiscount);
                } else {
                    System.out.printf("Studio: %.2f lv.", studioNights);
                }
                break;
            case "July":
                studioNights = 76 * nights;
                apartmentNights = 77 * nights;
                if (nights > 14) {
                    double apartmentDiscount = apartmentNights - (apartmentNights * 0.1);
                    System.out.printf("Apartment: %.2f lv.%n", apartmentDiscount);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", apartmentNights);
                }
                System.out.printf("Studio: %.2f lv.", studioNights);
                break;
            case "August":
                studioNights = 76 * nights;
                apartmentNights = 77 * nights;
                if (nights > 14) {
                    double apartmentDiscount = apartmentNights - (apartmentNights * 0.1);
                    System.out.printf("Apartment: %.2f lv.%n", apartmentDiscount);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", apartmentNights);
                }
                System.out.printf("Studio: %.2f lv.", studioNights);
                break;
            case "September":
                studioNights = 75.20 * nights;
                apartmentNights = 68.70 * nights;
                if (nights > 14) {
                    double apartmentDiscount = apartmentNights - (apartmentNights * 0.1);
                    System.out.printf("Apartment: %.2f lv.%n", apartmentDiscount);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", apartmentNights);
                }
                if (nights > 14) {
                    double studioDiscount = studioNights - (studioNights * 0.20);
                    System.out.printf("Studio: %.2f lv.", studioDiscount);
                } else {
                    System.out.printf("Studio: %.2f lv.", studioNights);
                }
                break;
            case "October":
                studioNights = 50 * nights;
                apartmentNights = 65 * nights;
                if (nights > 14) {
                    double apartmentDiscount = apartmentNights - (apartmentNights * 0.1);
                    System.out.printf("Apartment: %.2f lv.%n", apartmentDiscount);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", apartmentNights);
                }
                if (nights > 14) {
                    double studioDiscount = studioNights - (studioNights * 0.30);
                    System.out.printf("Studio: %.2f lv.", studioDiscount);
                } else if (nights > 7) {
                    double studioDiscount = studioNights - (studioNights * 0.05);
                    System.out.printf("Studio: %.2f lv.", studioDiscount);
                } else {
                    System.out.printf("Studio: %.2f lv.", studioNights);

                }
                break;
        }
    }
}
