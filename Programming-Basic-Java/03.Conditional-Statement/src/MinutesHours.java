import java.util.Scanner;

public class MinutesHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int startHour = Integer.parseInt(scanner.nextLine());
        int startMinute = Integer.parseInt(scanner.nextLine());
        // time in minute to sum
        int totalMinutes = startHour * 60 + startMinute;
        int plusMinutes = totalMinutes + 15;
        //sum time in hour
        int finalHour = plusMinutes / 60;
        int finalMinutes = plusMinutes % 60;

        if (finalHour >= 24) {
            finalHour -= 24;
        }
        if (finalMinutes < 10) {
            System.out.printf("%d:0%d", finalHour, finalMinutes);
        }else {
            System.out.printf("%d:%d", finalHour, finalMinutes);
        }
    }
}
