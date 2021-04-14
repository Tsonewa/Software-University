import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder stringBuilder = new StringBuilder();
        ArrayDeque<String> undoText = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command){
                case "1":
                    String toAppend = input[1];
                    undoText.push(stringBuilder.toString());
                    stringBuilder.append(toAppend);
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    undoText.push(stringBuilder.toString());
                    stringBuilder.delete(stringBuilder.length() - count, stringBuilder.length());
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    System.out.println(stringBuilder.charAt(index - 1));
                    break;
                case "4":
                    stringBuilder.replace(0, stringBuilder.length(), undoText.pop());
                    break;
            }
        }
    }
}
