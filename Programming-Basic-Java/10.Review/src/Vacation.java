import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int numberPeople = Integer.parseInt(scanner.nextLine());
        String typeVacation = scanner.nextLine();
        String typeDay = scanner.nextLine();
        double price = 0;

        if (typeVacation.equals("Students")) {
            if (typeDay.equals("Friday")) {
                price = numberPeople * 8.45;
            } else if (typeDay.equals("Saturday")) {
                price = numberPeople * 9.80;
            } else if (typeDay.equals("Sunday")) {
                price = numberPeople * 10.46;
            }
            if (numberPeople >= 30) {
                price *= 0.85;
            }
        } else if (typeVacation.equals("Business")) {
            if (typeDay.equals("Friday")) {
                if (numberPeople >= 100) {
                    price = (numberPeople - 10) * 10.90;
                } else {
                    price = numberPeople * 10.90;
                }
            } else if (typeDay.equals("Saturday")) {
                if (numberPeople >= 100) {
                    price = (numberPeople - 10) * 15.60;
                } else {
                    price = numberPeople * 15.60;
                }
            } else if (typeDay.equals("Sunday")) {
                if (numberPeople >= 100) {
                    price = (numberPeople - 10) * 16;
                } else {
                    price = numberPeople * 16;
                }
            }
        } else if (typeVacation.equals("Regular")) {
            if (typeDay.equals("Friday")) {
                price = numberPeople * 15;
            } else if (typeDay.equals("Saturday")) {
                price = numberPeople * 20;
            } else if (typeDay.equals("Sunday")) {
                price = numberPeople * 22.50;
            }
            if (numberPeople >= 10 && numberPeople <= 20) {
                price *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f", price);
    }
}