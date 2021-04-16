import java.util.Scanner;

public class Exam4 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //input
    String nameOfplayer = scanner.nextLine();
    String input = scanner.nextLine(); //Single", "Double" или "Triple
    int havePoints = 301;
    int countShots = 0;
    int countFailShot = 0;

    while (!input.equals("Retire")) {
        int point = Integer.parseInt(scanner.nextLine());

        if (input.equals("Single")) {
            havePoints -= point;
            countShots++;
            if (havePoints < 0) {
                countFailShot++;
                countShots--;
                havePoints += point;

            }
        } else if (input.equals("Double")) {
            havePoints = havePoints - (point * 2);
            countShots++;
            if (havePoints < 0) {
                countFailShot++;
                countShots--;
                havePoints += point * 2;
            }
        } else if (input.equals("Triple")) {
            havePoints = havePoints - (point * 3);
            countShots++;
            if (havePoints < 0) {
                countFailShot++;
                countShots--;
                havePoints += point * 3;
            }
        }
        if (havePoints == 0) {
            System.out.printf("%s won the leg with %d shots.", nameOfplayer, countShots);
            break;
        }
        input = scanner.nextLine();
    }
    if (havePoints != 0) {
        System.out.printf("%s retired after %d unsuccessful shots.", nameOfplayer, countFailShot);
    }
}
}
