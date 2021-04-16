import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] operations = scanner.nextLine().split(" ");
        int n = Integer.parseInt(operations[0]);
        int s = Integer.parseInt(operations[1]);
        int x = Integer.parseInt(operations[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()){
            System.out.print("0");
        }else {

            if (queue.contains(x)){
                System.out.println("true");
            }else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
