import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ") ;

        List<Integer> numbersFirstLine = new ArrayList<>();
        List<Integer> numbersSecondLine = new ArrayList<>();

        for (int i = 0; i < firstLine.length ; i++) {
        numbersFirstLine.add(Integer.parseInt(firstLine[i])); //3.5.2.43.12.3.54.10.23
        }
        for (int i = 0; i < secondLine.length; i++) {
        numbersSecondLine.add(Integer.parseInt(secondLine[i])); //76.5.3.4.2.4.5
        }
        List<Integer> result = new ArrayList<>();
        int maxSize = Math.max(numbersFirstLine.size(), numbersSecondLine.size());
        for (int i = 0; i < maxSize ; i++) {
        if (i < numbersFirstLine.size()) {
        result.add(numbersFirstLine.get(i));
        }
        if (i < numbersSecondLine.size()) {
        result.add(numbersSecondLine.get(i));
        }
        }
        for (Integer number: result) {
        System.out.print(number + " ");
        }
        }
        }
