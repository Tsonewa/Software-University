import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int target = 10000;
        int stepsCount = 0;
        String input = scanner.nextLine();

        while (true) {
            if ("Going home".equals(input)) {
                int lastSteps = Integer.parseInt(scanner.nextLine());
                stepsCount += lastSteps;
                break;
            }
            int steps = Integer.parseInt(input);
            stepsCount += steps;
            if (stepsCount >= target) {
                break;
            }
            input = scanner.nextLine();
        }
        if (stepsCount >= target) {
            System.out.println("Goal reached! Good job!");
        } else {
            System.out.printf("%d more steps to reach goal.", target - stepsCount);
        }
    }
    }