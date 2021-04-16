import java.util.Scanner;

public class DanceHall {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        double wardrobeSide = Double.parseDouble(scanner.nextLine());

        double danceHallArea = (length * 100) * (weight * 100);
        double wardrobeArea = (wardrobeSide * 100) * (wardrobeSide * 100);
        double bench = danceHallArea / 10;

        double freeSpace = danceHallArea - wardrobeArea - bench;
        double dancers = freeSpace / (40 + 7000);

        System.out.printf("%.0f", Math.floor(dancers));
    }
}
