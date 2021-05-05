import java.util.Scanner;

public class InchToCm {
    static public void main (String[] arg) {
        Scanner scaner = new Scanner(System.in) ;
        double inches = Double.parseDouble(scaner.nextLine());
        double centimeters = inches * 2.54;
        System.out.printf("%.2f" , centimeters);
    }
}
