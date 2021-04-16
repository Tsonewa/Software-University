import java.util.Scanner;

public class PointinRectangularExercaces {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input x1, y1, x2, y2, x и y
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        // firstcheck for equal x
        boolean xEqual = x == x1 || x== x2;
        boolean yBetween = y >= y1 && y<= y2;
        boolean firstCheck = xEqual && yBetween;
        // secondcheck  for equal y
        boolean yEqual = y == y1 || y == y2;
        boolean xBetween = x >= x1 && x<= x2;
        boolean secondCheck = yEqual && xBetween;
        // if equals is Border if not Inside / Outside
        if (firstCheck || secondCheck) {
            System.out.println("Border");
        }else {
            System.out.println("Inside / Outside");
        }
    }
}
