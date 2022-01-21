import implementations.ArrayList;
import implementations.Queue;
import implementations.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new Queue<>();

        stack.push("Pesho");
        stack.push("Gosho");
        stack.push("Dicho");

        System.out.println(stack.size());

        for (int i = stack.size(); i > 0; i--) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.isEmpty());

        queue.offer("Pesho");
        queue.offer("Gosho");
        queue.offer("Dicho");

        System.out.println(queue.size());

        for (int i = queue.size(); i > 0; i--) {
            System.out.println(queue.poll());
        }

        System.out.println(queue.isEmpty());
    }
}
