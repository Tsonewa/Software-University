import java.util.Scanner;

public class RageExpences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int lostGametimes = Integer.parseInt(scanner.nextLine());
        double priceHeadset = Double.parseDouble(scanner.nextLine());
        double priceMouse = Double.parseDouble(scanner.nextLine());
        double priceKeyboard = Double.parseDouble(scanner.nextLine());
        double priceDisplay = Double.parseDouble(scanner.nextLine());

        int headsets = lostGametimes / 2;
        int mouses = lostGametimes / 3;
        int keyboards = lostGametimes / 6;
        int displays = lostGametimes / 12;

        double totalDemegePrice = headsets * priceHeadset + mouses * priceMouse + keyboards * priceKeyboard + displays * priceDisplay;
        System.out.printf("Rage expenses: %.2f lv.", totalDemegePrice);
    }
}
