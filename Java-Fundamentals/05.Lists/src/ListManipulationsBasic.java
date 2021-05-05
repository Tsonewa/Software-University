import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationsBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("end")) {

            String[] operation = line.split(" ");
            switch (operation[0]) {
                case "Add":
                    int numAdd = Integer.parseInt(operation[1]);
                    numbers.add(numAdd);
                    break;
                case "Remove":
                    int numRemove = Integer.parseInt(operation[1]);
                    numbers.remove((Object)numRemove);
                    break;
                case "RemoveAt":
                    int removeAt = Integer.parseInt(operation[1]);
                    numbers.remove(removeAt);
                    break;
                case "Insert":
                    int index = Integer.parseInt(operation[1]);
                    int numInsert = Integer.parseInt(operation[2]);
                    numbers.add(numInsert, index);
                    break;
            }
            line = scanner.nextLine();
        }
        for (int num: numbers) {
            System.out.print(num + " ");
        }
    }
}
