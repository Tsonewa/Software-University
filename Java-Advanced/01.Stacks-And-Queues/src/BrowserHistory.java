import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String line = scanner.nextLine();

        String current = "";

        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (!history.isEmpty()) {
                    current = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    history.push(current);
                }
                current = line;
            }
            System.out.println(current);
            line = scanner.nextLine();
        }
    }


}