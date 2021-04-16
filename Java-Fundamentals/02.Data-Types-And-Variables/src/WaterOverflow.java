import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int input = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < input ; i++) {
            int amountWater = Integer.parseInt(scanner.nextLine());
            sum += amountWater;

            if (sum > 255){
                System.out.println("Insufficient capacity!");
                sum-=amountWater;
            }
        }
        System.out.println(sum);
    }
}