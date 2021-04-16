import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        //1 centuries = 100 years = 36524 days = 876576 hours = 52594560 minutes
        int centure = Integer.parseInt(scanner.nextLine());
        int years = centure * 100;
        double days = years * 365.2422;
        int dayTotal = (int) days;
        int haurs = dayTotal * 24;
        int minutes = haurs * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centure, years,dayTotal,haurs,minutes);
    }
}