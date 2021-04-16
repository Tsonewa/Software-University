import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sets = scanner.nextLine().split("\\s+");
        int firstSet = Integer.parseInt(sets[0]);
        int secondSet= Integer.parseInt(sets[1]);

        Set<Integer> first = readSet(scanner,firstSet);
        Set<Integer> second = readSet(scanner,secondSet);

        first.retainAll(second);

        first.stream().forEach(e -> System.out.print(e + " "));

    }public static LinkedHashSet<Integer> readSet (Scanner scanner, int count){
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < count ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            set.add(number);
        }
        return set;
    }
}
