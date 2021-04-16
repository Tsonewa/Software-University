import java.util.Scanner;

public class PadawainEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double budget = Double.parseDouble(scanner.nextLine());
        int numberStudents = Integer.parseInt(scanner.nextLine());
        double priceLightsabes = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts=Double.parseDouble(scanner.nextLine());

        double numberOfLighrsabes = Math.ceil(numberStudents * 1.1) * priceLightsabes;
        double numberOfRobes = numberStudents * priceRobes;
        int freeBelts = numberStudents / 6;
        double numberOfBelts = (numberStudents - freeBelts ) * priceBelts;
        double totalSum = numberOfLighrsabes + numberOfBelts + numberOfRobes;
        double needMoney = totalSum - budget;

        if (budget >= totalSum){
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        }else {
            System.out.printf("Ivan Cho will need %.2flv more.", needMoney);
        }
    }
}
