import java.util.Scanner;

public class Exam6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
            String nameTourin = scanner.nextLine();
            int countWin = 0;
            int countLose = 0;
            int gameNumber = 0;

            while (!nameTourin.equals("End of tournaments")){
                int countGame = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < countGame; i++) {
                    int pointDesi = Integer.parseInt(scanner.nextLine());
                    int pointEnemies = Integer.parseInt(scanner.nextLine());
                    if (pointDesi > pointEnemies){
                        int win = pointDesi - pointEnemies;
                        gameNumber++;
                        countWin++;
                        System.out.printf("Game %d of tournament %s: win with %d points.%n", i + 1,nameTourin, win);
                    }else {
                        int lose = pointEnemies - pointDesi;
                        ++gameNumber;
                        countLose++;
                        System.out.printf("Game %d of tournament %s: lost with %d points.%n", i+ 1,nameTourin, lose);
                    }
                }
                nameTourin = scanner.nextLine();
            }
            double purcentMachesWin = (countWin * 1.0 / gameNumber) * 100;
            double purcentMachesLose = (countLose * 1.0 / gameNumber) * 100;
        System.out.printf("%.2f%% matches win%n", purcentMachesWin);
        System.out.printf("%.2f%% matches lost", purcentMachesLose);

    }
}
