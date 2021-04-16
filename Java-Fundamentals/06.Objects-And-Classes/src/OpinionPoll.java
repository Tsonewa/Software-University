import java.util.ArrayList;
import java.util.Scanner;

public class OpinionPoll {
    public static  class Person{
        String name;
        int age;
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        public int getAge(){
            return this.age;
        }

        public String getName(){
            return this.name;
        }
        @Override
        public String toString(){
            //Ivan - 48
            String result = String.format("%s - %d", this.name,this.age);
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        int input = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < input ; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            Person person = new Person(name, age);
            people.add(person);
        }
        people.stream().filter(p -> p.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()) )
                .forEach(p -> System.out.println(p.toString()));
    }
}
