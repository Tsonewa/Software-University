import java.util.Scanner;

public class BackInThirtyMinutes {
    public static void main (String[] arg){
        Scanner scanner = new Scanner(System.in);
        //input
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes= Integer.parseInt(scanner.nextLine());
        minutes += 30;

        if(minutes >= 60){
            hour ++;
            minutes -= 60;

            if (hour >= 24){
                hour -= 24;
        }
        }
        if (minutes <= 9){
            System.out.printf("%d:0%d%n", hour, minutes);
        }else {
            System.out.printf("%d:%d%n", hour, minutes);
        }
    }
}
