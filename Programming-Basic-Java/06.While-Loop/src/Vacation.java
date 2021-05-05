import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double needMoney = Double.parseDouble(scanner.nextLine());
        double currentMoney = Double.parseDouble(scanner.nextLine());
        int saveDay = 0;
        int spendDays = 0;

        while (currentMoney < needMoney) {
            String whatDone = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());

            if (whatDone.equals("spend")) {
                spendDays++;
                saveDay++;
                currentMoney -= money;

                if (money > currentMoney){
                    currentMoney = 0;
                }
                    if (spendDays == 5) {
                        System.out.println("You can't save the money.");
                        System.out.printf("%d", spendDays);
                        break;
                    }
            } else if (whatDone.equals("save")) {
                currentMoney += money;
                saveDay++;
                if (currentMoney >= needMoney) {
                    System.out.printf("You saved the money for %d days.", saveDay);
                }
            }
        }
    }
}