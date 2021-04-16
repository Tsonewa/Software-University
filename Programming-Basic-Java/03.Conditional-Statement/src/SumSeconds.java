import java.util.Scanner;

public class SumSeconds {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input
        int firstTime = Integer.parseInt(scanner.nextLine());
        int secondTime = Integer.parseInt(scanner.nextLine());
        int thirdTime = Integer.parseInt(scanner.nextLine());
        //minutes
        int sum = firstTime + secondTime + thirdTime;
        int minutes = sum / 60;
        int seconds = sum % 60;

        if (seconds < 10) {
            System.out.println(minutes + ":0" + seconds);
        }else {
            System.out.println (minutes + ":" + seconds);
        }
        }

    }