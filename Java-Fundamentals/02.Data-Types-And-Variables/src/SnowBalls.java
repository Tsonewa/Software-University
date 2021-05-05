import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long maxValue = Integer.MIN_VALUE;
        String print = ":";
        int maxSnow = 0;
        int maxTime = 0;
        int maxQual = 0;

        for (int i = 0; i < n ; i++) {

            int snowBall = Integer.parseInt(scanner.nextLine());
            int snowTime = Integer.parseInt(scanner.nextLine());
            int snowQuality = Integer.parseInt(scanner.nextLine());

            double sum = Math.pow((snowBall * 1.0/ snowTime), snowQuality);
            long total = (long) sum;
            if (snowBall > maxValue) {
                maxValue = snowBall;
                maxSnow = snowBall;
                maxTime = snowTime;
                maxQual = snowQuality;
            }
            if (total > maxValue) {
                maxValue =(int)sum;
            }
        }
        System.out.printf("%d %s %d = %d (%d)", maxSnow,print, maxTime, maxValue, maxQual);
    }
}