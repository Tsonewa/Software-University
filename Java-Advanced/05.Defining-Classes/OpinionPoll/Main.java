package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (age > 30) {
                persons.add(new Person(name, age));
            }
        }
            persons.sort(Comparator.comparing(p -> p.getName()));
            for (Person name : persons
            ) {
                System.out.println(String.format("%s - %d", name.getName(), name.getAge()));
            }
        }}

