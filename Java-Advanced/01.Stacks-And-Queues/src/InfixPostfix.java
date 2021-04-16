import java.util.*;

public class InfixPostfix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String result = infixToPostFix(expression);
        char[] end = result.toCharArray();
        for (Character element: end
             ) {
            if (element != ' ') {
                System.out.print(element + " ");
            }
        }
    }
    public static int precedence ( char c){
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
        public static String infixToPostFix(String expression){

            String result = "";
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i <expression.length() ; i++) {
                char c = expression.charAt(i);

                //check if char is operator
                if(precedence(c)>0){
                    while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                        result += stack.pop();
                    }
                    stack.push(c);
                }else if(c==')'){
                    char x = stack.pop();
                    while(x!='('){
                        result += x;
                        x = stack.pop();
                    }
                }else if(c=='('){
                    stack.push(c);
                }else{
                    //character is neither operator nor (
                    result += c;
                }
            }
            for (int i = 0; i <= stack.size() ; i++) {
                result += stack.pop();
            }
            return result;
        }
    }
