package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("END")){
            String[] personInfo = input.split("\\s+");
            String name = personInfo[0];
            int years = Integer.parseInt(personInfo[1]);
            String town = personInfo[2];
            Person person = new Person(name, years, town);
            people.add(person);

            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person comparePerson = people.get(n - 1);

        int countEqual = 0;

        for (Person person: people) {
            if (person.compareTo(comparePerson) == 0){
                countEqual++;
            }
        }
        if (countEqual == 1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d%n", countEqual, people.size() - countEqual, people.size());
        }
    }
}
