import java.util.Scanner;

public class MultiplyBigNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        if (multiplier == 0){
            System.out.println(0);
            return;
        }
        while (number.charAt(0) == '0'){
            number = number.substring(1);
        }

        StringBuilder newNumber =  new StringBuilder();
        int reminder = 0;
        for (int i = number.length() - 1; i >= 0; i--) {

            int curDigit = Integer.parseInt(String.valueOf(number.charAt(i)));
            int newDigit = curDigit * multiplier + reminder;

            newNumber.append(newDigit % 10);
            reminder = newDigit / 10;
        }

        if (reminder != 0){
            newNumber.append(reminder);
        }

        System.out.println(newNumber.reverse());
    }
}