import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String fruit = scanner.nextLine(); //"Watermelon", "Mango", "Pineapple" или "Raspberry"
        String size = scanner.nextLine(); //small или big
        int countSet = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (size){
            case "small":
                if (fruit.equals("Watermelon")){
                    price += 56 * 2;
                }else if (fruit.equals("Mango")){
                    price += 36.66 * 2;
                }else if (fruit.equals("Pineapple")){
                    price += 42.1 * 2;
                }else if (fruit.equals("Raspberry")){
                    price += 20 * 2;
                }
                break;
            case "big" :
                if (fruit.equals("Watermelon")){
                    price += 28.7 * 5;
                }else if (fruit.equals("Mango")){
                    price += 19.6 * 5;
                }else if (fruit.equals("Pineapple")){
                    price += 24.8 * 5;
                }else if (fruit.equals("Raspberry")){
                    price += 15.2 * 5;
                }
                break;
        }
        double totalPrice = countSet * price;
        if (totalPrice >= 400 && totalPrice <= 1000){
            totalPrice = totalPrice - (totalPrice * 0.15);
        }else if (totalPrice > 1000){
            totalPrice = totalPrice / 2;

        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}
