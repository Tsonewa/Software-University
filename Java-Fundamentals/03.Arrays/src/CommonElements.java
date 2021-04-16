import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();
        String[] firstLineofElements = firstInput.split(" ");
        String[] secondLineElements = secondInput.split(" ");

        for (int i = 0; i < firstLineofElements.length; i++) {
            String firstElement = firstLineofElements[i];
            for (int j = 0; j < secondLineElements.length; j++) {
                if (firstElement.equals(secondLineElements[j])) {
                    System.out.print(secondLineElements[j]+ " ");
                }
            }
        }
    }
}
