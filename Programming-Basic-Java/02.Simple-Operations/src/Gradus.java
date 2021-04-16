import java.util.Scanner;

public class Gradus {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        double cel = Double.parseDouble(scanner.nextLine());
        double far = 32 + cel * 1.8000;

        System.out.printf("%.2f",far);
    }
}

