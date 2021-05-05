import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int numberHrizantemi = Integer.parseInt(scanner.nextLine());
        int numberRose = Integer.parseInt(scanner.nextLine());
        int numerLaleta = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine(); //Spring, Summer, Аutumn, Winter]
        char weekend = 'Y';
        String umPrice = weekend + "";
        double priceHrizantemi = 0;
        double priceRose = 0;
        double priceLaleta = 0;

    switch (season){
        case "Spring":
            priceHrizantemi += numberHrizantemi * 2.00;
            priceRose += numberRose * 4.10;
            priceLaleta += numerLaleta * 2.50;
            break;
        case "Summer":
            priceHrizantemi += numberHrizantemi * 2.00;
            priceRose += numberRose * 4.10;
            priceLaleta += numerLaleta * 2.50;
            break;
        case "Autumn":
            priceHrizantemi += numberHrizantemi * 3.75;
            priceRose += numberRose * 4.50;
            priceLaleta += numerLaleta * 4.15;
            break;
        case "Winter":
            priceHrizantemi += numberHrizantemi * 3.75;
            priceRose += numberRose * 4.50;
            priceLaleta += numerLaleta * 4.15;
            break;
    }
    double priceFlower = priceHrizantemi + priceRose + priceLaleta;
    double numberFlowers = numberHrizantemi + numberRose + numerLaleta;

    if (umPrice.equals("Y")){
        priceFlower = priceFlower + (priceFlower * 0.15);
    }else if (umPrice.equals("N")){
        priceFlower = priceFlower + (priceFlower * 0);
    }
    if (numerLaleta > 7 && season.equals("Spring")){
        priceFlower = priceFlower - (priceFlower * 0.05);
    }
    if (numberRose >= 10 && season.equals("Winter")){
        priceFlower = priceFlower - (priceFlower * 0.1);
    }
    if (numberFlowers > 20){
        priceFlower = priceFlower - (priceFlower * 0.2);
    }
    double sum = priceFlower + 2;
        System.out.printf("%.2f",sum);
        }
    }
