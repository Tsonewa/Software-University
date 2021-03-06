package ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(data);

        String command = scanner.nextLine();
        while (!command.equals("END")){
            if (listyIterator.getData().size() == 0){
                System.out.println("Invalid Operation!");
                break;
            }
                switch (command) {
                    case "Move":
                        System.out.println(listyIterator.Move());
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.HasNext());
                        break;
                    case "Print":
                        System.out.println(listyIterator.toString());
                        break;
                    default:
                        System.out.println("Invalid Operation!");
                }
            command = scanner.nextLine();
        }
    }
}
