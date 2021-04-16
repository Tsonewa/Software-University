import java.util.Scanner;

public class DemoLesson {
    public static int countNumberOfSpecialSheets(int numberOfSheets) {
        int count = 0;
        for (int i = 1; i <= numberOfSheets; i++) {
            if (i % 3 == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double sizeOfOneSide = Double.parseDouble(scanner.nextLine());
        int numberOfSheets = Integer.parseInt(scanner.nextLine());
        double areaCoveredByOneSheet = Double.parseDouble(scanner.nextLine());

        double area = (sizeOfOneSide * sizeOfOneSide) * 6;
        int fullCoverSheet = numberOfSheets - countNumberOfSpecialSheets(numberOfSheets);

        double fullSheetCover = fullCoverSheet * areaCoveredByOneSheet;
        double specialSheetCover = countNumberOfSpecialSheets(numberOfSheets) * (areaCoveredByOneSheet * 0.25);

        double totalCoverArea = fullSheetCover + specialSheetCover;
        double percantage = (totalCoverArea * 100) /  area;

        System.out.printf("You can cover %.2f%% of the box.", percantage);
    }
}
