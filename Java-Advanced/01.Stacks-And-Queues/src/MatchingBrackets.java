import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '('){
                indexes.push(i);
            } else if (symbol == ')'){
                String selectExpression = expression.substring(indexes.pop(), i + 1);
                System.out.println(selectExpression);
            }
        }

    }
}
