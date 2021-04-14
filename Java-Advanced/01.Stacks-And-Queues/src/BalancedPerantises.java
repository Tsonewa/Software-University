import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedPerantises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> open = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                open.push(currentChar);
            } else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {

                if (open.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char openBreckets = open.pop();
                if (currentChar == '}' && openBreckets != '{') {

                    isBalanced = false;
                } else if (currentChar == ']' && openBreckets != '[') {

                    isBalanced = false;
                } else if (currentChar == ')' && openBreckets != '(') {

                    isBalanced = false;
                }
            }
        }
        if (isBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
