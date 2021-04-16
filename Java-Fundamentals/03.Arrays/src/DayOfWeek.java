import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = scanner.nextInt();
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (n > 0 && n <= 7){
            System.out.println(weekDays[n - 1]);
        }else {
            System.out.println("Invalid day!");
        }
    }
}
