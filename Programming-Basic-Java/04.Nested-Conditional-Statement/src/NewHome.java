import java.util.Scanner;

public class NewHome {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        String typeOfFlower = scanner.nextLine();
        int countFlower = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        // total price = count flower * price per type
        double priceForFlower = 0;

        switch (typeOfFlower){
            case "Roses":
                priceForFlower = 5.00;
                break;
            case "Dahlias":
                priceForFlower = 3.80;
                break;
            case "Tulips":
                priceForFlower = 2.80;
                break;
            case "Narcissus":
                priceForFlower = 3.00;
                break;
            case "Gladiolus":
                priceForFlower = 2.50;
                break;
        }
        // total price discount
        double totalPrice = countFlower * priceForFlower;

        if (countFlower > 80 && typeOfFlower.equals("Roses")){
            totalPrice = 0.9 * totalPrice;
        }else if (countFlower > 90 && typeOfFlower.equals("Dahlias")){
            totalPrice = 0.85 * totalPrice;
        }else if (countFlower > 80 && typeOfFlower.equals("Tulips")){
            totalPrice = 0.85 * totalPrice;
        }else if (countFlower < 120 && typeOfFlower.equals("Narcissus")){
            totalPrice = 1.15 * totalPrice;
        }else if (countFlower < 80 && typeOfFlower.equals("Gladiolus")){
            totalPrice = 1.2 * totalPrice;
        }
        // budget --> is it enough or not
        if (budget >= totalPrice){
            double leftMoney = budget - totalPrice;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", countFlower, typeOfFlower, leftMoney );
        }else {
            double needMoney = totalPrice - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", needMoney);
        }

    }
}
