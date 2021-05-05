package FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<BaseBuyer> buyers = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if(input.length == 4){
                buyers.add(new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]));
            } else {
                buyers.add(new Rebel(input[0], Integer.parseInt(input[1]), input[2]));
            }
        }

        String name = scanner.nextLine();

        while (!name.equals("End")){

            for (BaseBuyer b: buyers) {

                if(b.getName().equals(name)){
                    b.buyFood();
                }
            }
            name = scanner.nextLine();
        }

        int result = buyers.stream().mapToInt(BaseBuyer::getFood).sum();
        System.out.println(result);
    }
}
