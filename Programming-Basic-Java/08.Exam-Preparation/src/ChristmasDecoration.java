import java.util.Scanner;

public class ChristmasDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int budget = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Stop")){
            int sum = 0;
            for (int i = 0; i < input.length() ; i++) {
                sum += input.charAt(i);
            }
          budget = budget - sum;
            if (budget >= 0 ){
                System.out.println("Item successfully purchased!");
            }else {
                System.out.println("Not enough money!");
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("Stop")){
            System.out.printf("Money left: %d", budget);
        }

    }
}
