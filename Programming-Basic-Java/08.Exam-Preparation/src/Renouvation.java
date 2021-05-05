import java.util.Scanner;

public class Renouvation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double budget = Double.parseDouble(scanner.nextLine());
        double floorWeight = Double.parseDouble(scanner.nextLine());
        double floorLenght = Double.parseDouble(scanner.nextLine());
        double  triangleSide= Double.parseDouble(scanner.nextLine());
        double triangleHigh = Double.parseDouble(scanner.nextLine());
        double priceOneStone = Double.parseDouble(scanner.nextLine());
        double priceForCreator = Double.parseDouble(scanner.nextLine());

        double floorObem = floorLenght * floorWeight;
        double stoneSize = (triangleHigh * triangleSide)/ 2;
        double stoneNeed = Math.ceil(floorObem / stoneSize);
        double stoneFinal = stoneNeed + 5;

        double totalSum = (stoneFinal * priceOneStone) + priceForCreator;
        if (budget >= totalSum){
            double moneuLeft = budget - totalSum;
            System.out.printf("%.2f lv left.",moneuLeft);
        }else {
            double diffMoney = totalSum - budget;
            System.out.printf("You'll need %.2f lv more.", diffMoney);
        }
    }
}
