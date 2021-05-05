import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arriveHour = Integer.parseInt(scanner.nextLine());
        int arriveMinutes = Integer.parseInt(scanner.nextLine());
        int examTime = examHour * 60 + examMinutes;
        int arriveTime = arriveHour * 60 + arriveMinutes;
        // to find out ; am i late, on time or early
        if (arriveTime > examTime){
            System.out.println("Late");
            int lateTime = arriveTime - examTime;
            if (lateTime < 60) {
                System.out.printf("%d minutes after the start" , lateTime);
            }else {
                int lateHour = lateTime / 60;
                int lateMinutes = lateTime % 60;
                System.out.printf("%d:%02d hours after the start", lateHour,lateMinutes);
            }
        }else if (examTime - arriveTime <= 30){
            System.out.println("On time");
            int onTime = examTime - arriveTime;
            if(onTime!= 0){
                System.out.printf("%d minutes before the start",onTime);
            }
        }else if (examTime - arriveTime > 30){
            System.out.println("Early");
            int early = examTime - arriveTime;
            if (early < 60){
                System.out.printf("%d minutes before the start", early);
            }else {
                int earlyHour = early / 60;
                int earlyMinutes = early % 60;
                System.out.printf("%d:%02d hours before the start", earlyHour,earlyMinutes);
            }
        }
        }
    }

