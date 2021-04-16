import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double recordInSecond = Double.parseDouble(scanner.nextLine());
        double distansMeters = Double.parseDouble(scanner.nextLine());
        double timeSecondsForMeter = Double.parseDouble(scanner.nextLine());

        double needTimeSecond = distansMeters * timeSecondsForMeter;
        double slowHigh = Math.floor(distansMeters / 50) * 30;
        double totalTime = needTimeSecond + slowHigh;
        double diff = totalTime - recordInSecond;
            if (recordInSecond > totalTime){
                System.out.printf("Yes! The new record is %.2f seconds.", totalTime);
            }else if (recordInSecond <= totalTime){
                System.out.printf("No! He was %.2f seconds slower.", diff);
            }
    }
}
