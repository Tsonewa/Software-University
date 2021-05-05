import java.util.Scanner;

public class Journey {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine(); //winter and summer
        //Somewhere in - Bulgaria, Balkans и Europe
        if (budget <= 100) {
            System.out.println("Somewhere in Bulgaria");
        } else if (budget > 100 && budget <= 1000) {
            System.out.println("Somewhere in Balkans");
        } else {
            System.out.println("Somewhere in Europe");
        }
        //spend money per season
                if ( season.equals("summer") && budget <= 100){
                     double sum = budget - (budget * 0.7);
                    System.out.printf("Camp - %.2f", sum);
                }else if (season.equals("summer") && budget > 100 && budget <= 1000){
                    double sum = budget - (budget * 0.6);
                    System.out.printf("Camp - %.2f", sum);
                }else if (season.equals("summer") && budget > 1000){
                    double sum = budget - (budget * 0.1);
                    System.out.printf("Hotel - %.2f", sum);
                }
                if (season.equals("winter")&& budget <= 100){
                    double diff = budget - (budget * 0.3);
                    System.out.printf("Hotel - %.2f", diff);
                }else if (season.equals("winter") && budget > 100 && budget <= 1000){
                    double diff = budget - (budget * 0.2);
                    System.out.printf("Hotel - %.2f", diff);
                }else if (season.equals("winter") && budget > 1000) {
                    double diff = budget - (budget * 0.1);
                    System.out.printf("Hotel - %.2f", diff);
                }
        }
        }