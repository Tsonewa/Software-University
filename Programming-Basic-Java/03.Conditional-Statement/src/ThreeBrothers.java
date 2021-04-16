import java.util.Scanner;

public class ThreeBrothers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double firstBrother = Double.parseDouble(scanner.nextLine());
        double secondBrother = Double.parseDouble(scanner.nextLine());
        double thirdBrother = Double.parseDouble(scanner.nextLine());
        double fathertime = Double.parseDouble(scanner.nextLine());
        // total time
        double cleaningTime = 1 / (1 / firstBrother + 1 / secondBrother + 1 / thirdBrother);
        double rest = 0.15 * cleaningTime;
        double totalTime = cleaningTime + rest;
        System.out.printf("Cleaning time: %.2f%n", totalTime);
        // surprise or no
        if (totalTime <= fathertime){
            double left = Math.floor(fathertime - totalTime);
            System.out.printf("Yes, there is a surprise - time left -> %.0f hours.", left);
        }else {
            double need = Math.ceil(totalTime - fathertime);
            System.out.printf("No, there isn't a surprise - shortage of time -> %.0f hours.", need);
        }
        }
    }