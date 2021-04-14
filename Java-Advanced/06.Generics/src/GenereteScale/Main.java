package GenericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scale<Character> numbers = new Scale<>('a','h');
        System.out.println(numbers.getHeavier());
    }
}
