import java.util.Scanner;

public class Alcohol {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        double whiskeyPrice = Double.parseDouble(scanner.nextLine());
        double beerLitres = Double.parseDouble(scanner.nextLine());
        double wineLitres = Double.parseDouble(scanner.nextLine());
        double brandyLitres = Double.parseDouble(scanner.nextLine());
        double whiskeyLitres = Double.parseDouble(scanner.nextLine());

        //alcohol price per liter
        double brandyPrice = whiskeyPrice / 2;
        double winePrice = brandyPrice - (0.4 * brandyPrice);
        double beerPrice = brandyPrice - (0.8 * brandyPrice);
        //price of alcohol from shop
        double beer = beerLitres * beerPrice;
        double wine = wineLitres * winePrice;
        double brandy = brandyLitres * brandyPrice;
        double whiskey = whiskeyPrice * whiskeyLitres;
        double own = beer + wine + brandy + whiskey;

        System.out.printf("%.2f",own);
    }
}
