import java.util.Scanner;

public class Steps {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int goalReached = 10000;
        int totalSteps = 0;

        while (totalSteps < goalReached){
           String input = scanner.nextLine();

           if (input.equals("Going home")){
               int bonusSteps = Integer.parseInt(scanner.nextLine());
               totalSteps += bonusSteps;
               break;
           }
           int steps = Integer.parseInt(input);
           totalSteps += steps;
        }
        if (totalSteps >= 10000){
            System.out.println("Goal reached! Good job!");
        }else
            System.out.printf("%d more steps to reach goal.", goalReached - totalSteps);
    }
}
