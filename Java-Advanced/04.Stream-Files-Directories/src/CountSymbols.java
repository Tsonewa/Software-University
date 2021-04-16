import java.util.*;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character,Integer> chars = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currChar =text.charAt(i);

            if (chars.containsKey(currChar)){
                chars.put(currChar, chars.get(currChar) + 1);
            } else {
                chars.put(currChar, 1);
            }
        }
        chars.entrySet().stream().forEach(entry ->{
            System.out.printf("%c: %d time/s%n", entry.getKey(),entry.getValue());
        } );
    }
}
