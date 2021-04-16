import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int minutsControla = Integer.parseInt(scanner.nextLine());
        int secondsControla = Integer.parseInt(scanner.nextLine());
        double lenghtUleiMetri = Double.parseDouble(scanner.nextLine());
        int secondsZaizminavanemetri = Integer.parseInt(scanner.nextLine());

        int controla = minutsControla * 60 + secondsControla;
        double slower = lenghtUleiMetri / 120;
        double totalSlow = slower * 2.5;

        double totalTime = (lenghtUleiMetri / 100) * secondsZaizminavanemetri - totalSlow;

        if (totalTime <= controla){
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", totalTime);
        } else {
            double diff = totalTime - controla;
            System.out.printf("No, Marin failed! He was %.3f second slower.", diff);
        }
    }
}
