package StrategyPattern;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> peopleCompareByNames = new TreeSet<>(new PersonNameComperator());
        Set<Person> peopleCompareByAge = new TreeSet<>(new PersonAgeComperator());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            peopleCompareByNames.add(person);
            peopleCompareByAge.add(person);
        }
        peopleCompareByNames.forEach(p-> System.out.println(p.toString()));
        peopleCompareByAge.forEach(e-> System.out.println(e.toString()));
    }
}
