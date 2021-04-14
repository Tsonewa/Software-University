import java.util.*;

public class PoisonousPlant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =  Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String numbrer: input
             ) {
            stack.push(Integer.parseInt(numbrer));
        }
        int result = (recurse(stack, n));
        System.out.println(n - result);
        }

    private static int recurse(ArrayDeque<Integer> stack, int n) {
        ArrayDeque<Integer> nextStack = new ArrayDeque<>();
        int stackSize = stack.size();
        if (n == 0){
            return n;
        }
        for (int i = 1; i < stackSize ; i++) {

            int rightNumber = stack.pop();
            int leftNumber = stack.peek();
            if (rightNumber < leftNumber){
                nextStack.push(rightNumber);
            }
        }
        while (!nextStack.isEmpty()){
            stack.push(nextStack.pop());
        }if (stackSize == stack.size()){
            return n;
        }
            return recurse(stack, n - 1);
    }
}
