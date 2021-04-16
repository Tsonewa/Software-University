import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack= new ArrayDeque<>();
        Collections.addAll(stack, numbers);

        while (!stack.isEmpty()){
            System.out.print(stack.pollLast() + " ");
        }
    }
}
