import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double hight = Double.parseDouble(scanner.nextLine());

        double volume = (length * width * hight) / 3;
        System.out.printf("Length: Width: Height: Pyramid Volume: %.2f", volume);
    }
}
