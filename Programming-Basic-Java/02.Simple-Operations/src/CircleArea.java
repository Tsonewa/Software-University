import java.util.Scanner;

public class CircleArea {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double area = Math.PI * r * r;
        double p = Math.PI *  r * 2;
        System.out.printf("%.2f", area);
        System.out.println();
        System.out.printf("%.2f", p);

    }
}
