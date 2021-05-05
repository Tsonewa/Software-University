package Word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String input txt
        Command word = new Command(scanner.nextLine());
        //Until the command exit -> read {commandName} {startIndex} {endIndex}(exclusive)
        String command = scanner.nextLine();

        while (!command.equals("exit")){
            String[] tokens = command.split("\\s+");
            int startIndex = Integer.parseInt(tokens[1]);
            int endIndex = Integer.parseInt(tokens[2]);

            switch (tokens[0]){
                case "uppercase":
                    word.uppercase(startIndex, endIndex);
                    break;
                case "cut":
                    word.cut(startIndex, endIndex);
                    break;
                case "paste":
                  word.paste(startIndex, endIndex);
                    break;
                default:
                    throw new IllegalStateException("Unknown switch statement " + tokens[0]);
            }
            command = scanner.nextLine();
        }
        System.out.println(word.getText());
    }
}
