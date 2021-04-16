import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> codeNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList()); // 1 2 2 4 2 2 2 9

        String[] specialCode = scanner.nextLine().split(" "); // "4", "2"
        int bombNumber = Integer.parseInt(specialCode[0]);// 4
        int indexRemoveNumber = Integer.parseInt(specialCode[1]); // 2


        while (codeNumbers.contains(bombNumber)) {
            int bombIndex = codeNumbers.indexOf(bombNumber);
            int maxLeftMove = Math.max(0, bombIndex - indexRemoveNumber);
            int maxRight = Math.min(indexRemoveNumber + bombIndex, codeNumbers.size() - 1);

            for (int i = maxRight; i >= maxLeftMove; i--) {
                codeNumbers.remove(i);
            }
        }
        int sum = 0;
        for (int i = 0; i < codeNumbers.size(); i++) {
            sum += codeNumbers.get(i);
        }
        System.out.print(sum);
    }
}