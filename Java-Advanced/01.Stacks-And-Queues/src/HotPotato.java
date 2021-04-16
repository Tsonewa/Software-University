import java.util.*;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

       ArrayDeque<String> queue = new ArrayDeque<>();
        for (String child: input
             ) {
            queue.offer(child);
        }
        while (queue.size() > 1){
            for (int i = 0; i < n - 1; i++) {
                queue.offer(queue.poll());
            }
            System.out.printf("Removed %s%n", queue.poll());
        }
        System.out.printf("Last is %s%n", queue.peek());
    }
}
