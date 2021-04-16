import java.util.Scanner;

public class VowelsCount {

    public static int vowelCounter(String word){
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.toLowerCase().charAt(i);
            if (letter == 'a' || letter == 'o' ||
                    letter == 'e' || letter == 'i' ||
                    letter == 'u' || letter == 'y'){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        System.out.println(vowelCounter(word));
    }
}
