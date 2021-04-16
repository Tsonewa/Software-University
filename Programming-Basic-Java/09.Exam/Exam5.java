import java.util.Scanner;

public class Exam5 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //input
        int client = Integer.parseInt(scanner.nextLine());
        int countBack = 0;
        int countChest = 0;
        int countLegs = 0;
        int countAbs = 0;
        int countShakes = 0;
        int countBar = 0;

    for (int i = 0; i < client ; i++) {
        String kindTrein = scanner.nextLine();
        if (kindTrein.equals("Back")) {
            countBack++;
        } else if (kindTrein.equals("Chest")) {
            countChest++;
        }else if (kindTrein.equals("Legs")){
            countLegs++;
        }else if (kindTrein.equals("Abs")){
            countAbs++;
        }else if (kindTrein.equals("Protein shake")){
            countShakes++;
        }else if (kindTrein.equals("Protein bar")){
            countBar++;
        }
    }
    double visitors = countAbs + countBack + countChest + countLegs;
    double things = countShakes + countBar;
    double percetnVisitors = (visitors / client) * 100;
    double pecentThings = (things / client) * 100;

    System.out.printf("%d - back%n", countBack);
    System.out.printf("%d - chest%n", countChest);
    System.out.printf("%d - legs%n", countLegs);
    System.out.printf("%d - abs%n", countAbs);
    System.out.printf("%d - protein shake%n", countShakes);
    System.out.printf("%d - protein bar%n", countBar);
    System.out.printf("%.2f%% - work out%n", percetnVisitors);
    System.out.printf("%.2f%% - protein%n", pecentThings);
}
}
