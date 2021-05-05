package CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomizeList<String> customList = new CustomizeList<>();

        String[] commandTokens = scanner.nextLine().split("\\s+");

        String command = commandTokens[0];

        while (!command.equals("END")) {
            switch (command) {
                case "Add":
                    customList.add(commandTokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.valueOf(commandTokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(commandTokens[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.valueOf(commandTokens[1]);
                    int secondIndex = Integer.valueOf(commandTokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterElement(commandTokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList.toString());
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
            commandTokens = scanner.nextLine().split("\\s+");
            command = commandTokens[0];
        }
    }
}