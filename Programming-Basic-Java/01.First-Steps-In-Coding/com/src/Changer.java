import java.util.Scanner;

public class Changer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double leva = Double.parseDouble(scanner.nextLine()) ;
        double euro = 1.95583;
        double area = leva/euro;
        System.out.println(area);
    }
}
