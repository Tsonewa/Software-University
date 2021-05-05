package Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stones = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        String end = scanner.nextLine();
        Lake lake = new Lake(stones);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }
        System.out.print(sb.substring(0, sb.toString().lastIndexOf(", ")));
    }
}
