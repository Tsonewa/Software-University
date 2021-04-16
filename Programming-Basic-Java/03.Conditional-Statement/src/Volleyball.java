import java.util.Scanner;

public class Volleyball {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        String year = scanner.nextLine(); // leap or normal
        int celebrates = Integer.parseInt(scanner.nextLine());
        int homeWeekend = Integer.parseInt(scanner.nextLine());
        int allWeekend = 48;
        int weekSofia = allWeekend - homeWeekend;
        double saturdayGameSofia = (weekSofia * 3.0) / 4;
        double celebrateInSofia = (celebrates * 2.0) / 3 ;
        if (year.equalsIgnoreCase("Normal")){
            double sum = saturdayGameSofia + homeWeekend + celebrateInSofia;
            System.out.printf("%.0f",Math.floor(sum));
        }else  if (year.equalsIgnoreCase("Leap")){
            double leapSum = saturdayGameSofia + homeWeekend + celebrateInSofia;
            double extraPlay = leapSum - (leapSum * 0.85);
            double leapYearGame = leapSum + extraPlay;
            System.out.printf( "%.0f", Math.floor(leapYearGame));
        }
    }
}
