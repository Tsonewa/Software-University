import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double avarage = Double.parseDouble(scanner.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name, age, avarage);
    }
}
