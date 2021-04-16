import java.util.Scanner;

public class FishingDay {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int countFishermen = Integer.parseInt(scanner.nextLine());
        double rent = 0;
        //price per different count of fishermen
        switch (season){
            case "Spring":
                rent = 3000;
                break;
            case "Summer":
                rent = 4200;
                break;
            case "Autumn":
                rent = 4200;
                break;
            case "Winter":
                rent = 2600;
                break;
        }
        if (countFishermen <= 6){
            rent = rent- (rent * 0.1);
        }else if (countFishermen > 7 && countFishermen <= 11){
            rent = rent - (rent * 0.15);
        }else if (countFishermen > 12){
            rent = rent - (rent * 0.25);
        }
        boolean even = countFishermen % 2 == 0;
        if ((countFishermen % 2) == 0 && !season.equals("Autumn")) {
            rent *= 0.95;
        }
        if (budget >= rent) {
            double finalMoney = budget - rent;
            System.out.printf("Yes! You have %.2f leva left.", finalMoney);
        }else{
            double moneyNeed = rent - budget;
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeed);
        }
        }

    }
