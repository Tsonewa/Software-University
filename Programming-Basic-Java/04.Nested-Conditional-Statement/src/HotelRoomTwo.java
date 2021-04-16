import java.util.Scanner;

public class HotelRoomTwo {public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    //input
    String month = scanner.nextLine();
    int nights = Integer.parseInt(scanner.nextLine());

    double studio = 0;
    double apartment = 0;

    switch (month) {
        case "May":
        case "October":
            studio = 50 * nights;
            apartment = 65 * nights;
            if (nights > 7 && nights <= 14) {
                studio *= 0.95;
            } else if (nights > 14) {
                studio *= 0.7;
                apartment *= 0.9;
            }
            break;
        case "June":
        case "September":
            studio = 75.2 * nights;
            apartment = 68.7 * nights;
            if (nights > 14){
                studio *= 0.8;
                apartment *= 0.9;
            }
            break;
        case "July":
        case "August":
            studio = 76 * nights;
            apartment = 77 * nights;
            if (nights > 14) {
                apartment *= 0.9;
            }
            break;
    }
        System.out.printf("Apartment: %.2f lv. %nStudio: %.2f lv.", apartment, studio);
}
}