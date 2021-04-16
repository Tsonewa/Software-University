import java.util.Scanner;

public class RectangularArea {

    public  static int printRectangularArea(int width, int length){
        return width * length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Create a method that calculates and returns the area of a rectangle by given width and length.
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(printRectangularArea(width, length));
    }
}
