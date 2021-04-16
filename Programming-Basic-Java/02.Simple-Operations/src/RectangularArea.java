import java.util.Scanner;

public class RectangularArea {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double lenght = Math.abs(x1 -x2);
        double weight = Math.abs(y1- y2);
        double area = lenght * weight;
        double peremeter = 2 * (lenght + weight);

        System.out.printf("%.2f%n",area);
        System.out.printf("%.2f", peremeter);
    }
}
