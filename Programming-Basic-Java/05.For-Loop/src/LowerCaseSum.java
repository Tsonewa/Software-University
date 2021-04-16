import java.util.Scanner;

public class LowerCaseSum {
    public static void main(String[] args) {
        char a = 'a';
        char e = 'e';
        char i = 'i';
        char o = 'o';
        char u = 'u';

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int sum = 0;

        for (int j = 0; j < text.length() ; j++) {
            char currentChar = text.charAt(j);

            switch (currentChar){
                case 'a' :
                    sum += 1;
                    break;
                case 'e' :
                    sum += 2;
                    break;
                case 'i' :
                    sum += 3;
                    break;
                case 'o' :
                    sum += 4;
                    break;
                case 'u' :
                    sum += 5;
                    break;

            }
        }
        System.out.println(sum);
    }
}
