import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int table = Integer.parseInt(scanner.nextLine());
        double lenght = Double.parseDouble(scanner.nextLine());
        double waight = Double.parseDouble(scanner.nextLine());
        double areaonecover = (lenght +2 * 0.30) * (waight + 2 * 0.30);
        double areaonesquare = (lenght / 2) * (lenght / 2);
        double areacovers = table * areaonecover;
        double areasquare = table * areaonesquare;
        double coverprice = areacovers * 7;
        double squareprice = areasquare * 9;
        double totalprice = coverprice + squareprice;
        double totapriseBGN = totalprice * 1.85;
        System.out.printf("%.2f USD%n",totalprice);
        System.out.printf("%.2f BGN", totapriseBGN);

    }
}

