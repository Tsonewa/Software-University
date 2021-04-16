import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        String firstName = names[0];
        String secondName = names[1];

        int min = Math.min(firstName.length(),secondName.length());
        int max = Math.max(firstName.length(),secondName.length());

        int sum = 0;

        for (int i = 0; i < max ; i++) {
            if (i < min){
                sum += firstName.charAt(i) * secondName.charAt(i);
            } else if (firstName.length() == max){
                sum += firstName.charAt(i);
            }else {
                sum += secondName.charAt(i);
            }
        }
        System.out.println(sum);
    }
}