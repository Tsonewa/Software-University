import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        int degree = Integer.parseInt(scanner.nextLine());
        String partOfDay = scanner.nextLine();

        if (degree >= 10 && degree <= 18) {
            if(partOfDay.equals("Morning")){
                System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers." , degree);
            }else if (partOfDay.equals("Afternoon")){
                System.out.printf("It's %d degrees, get your Shirt and Moccasins." , degree);
            }else if (partOfDay.equals("Evening")){
                System.out.printf("It's %d degrees, get your Shirt and Moccasins." , degree);
            }

        }else if (degree >=18 && degree <= 24){
            if(partOfDay.equals("Morning")){
                System.out.printf("It's %d degrees, get your Shirt and Moccasins." , degree);
            }else if (partOfDay.equals("Afternoon")){
                System.out.printf("It's %d degrees, get your T-Shirt and Sandals." , degree);
            }else if (partOfDay.equals("Evening")){
                System.out.printf("It's %d degrees, get your Shirt and Moccasins." , degree);
            }

        }else if (degree >= 25){
            if(partOfDay.equals("Morning")){
                System.out.printf("It's %d degrees, get your T-shirt and Sandals." , degree);
            }else if (partOfDay.equals("Afternoon")){
                System.out.printf("It's %d degrees, get your Swim Suit and Barefoot." , degree);
            }else if (partOfDay.equals("Evening")){
                System.out.printf("It's %d degrees, get your Shirt and Moccasins." , degree);
            }
        }
    }
}
