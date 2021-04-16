import java.util.Scanner;

public class ProjectPrize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int countProjectPart =Integer.parseInt(scanner.nextLine());
        double priceForPoint = Double.parseDouble(scanner.nextLine());
        double points = 0;
        for (int i = 0; i < countProjectPart ; i++) {
            int pointsForPart = Integer.parseInt(scanner.nextLine());
         if (i % 2 == 1){
             points += pointsForPart * 2;
         }else {
             points += pointsForPart;
         }
        }
        double prize = priceForPoint * points;
        System.out.printf("The project prize was %.2f lv.",prize);
    }
}
