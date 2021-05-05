import java.util.Scanner;

public class RadiansToDegrees {

    public static void main (String[] arg){
        Scanner scanner = new Scanner(System.in);
        // radian to degree .. degree = radian * 180/PI MATH.PI -"%.0f"
        double radian = Double.parseDouble(scanner.nextLine());
        double degree = radian * 180;
        double result = degree / Math.PI;

        System.out.printf("%.0f",result);
    }
}
