import java.util.Scanner;

public class SimpleOperations {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String output = "Hello, " + name + "!";

        System.out.println(output);
    }
}
