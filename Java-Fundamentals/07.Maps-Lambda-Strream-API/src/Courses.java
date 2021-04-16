import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> people = new LinkedHashMap<>();
        String input =scanner.nextLine();

        while(!input.equals("end")){
            String[] tokans = input.split(" : ");
            String course = tokans[0];
            String name = tokans[1];

            people.putIfAbsent(course, new ArrayList<>());
            people.get(course).add(name);

            input=scanner.nextLine();
        }

        people.entrySet()
                .stream()
                .sorted((p1,p2) -> {
                    int firse = p1.getValue().size();
                    int second = p2.getValue().size();
                    return Integer.compare(second,firse);
                }).forEach(p -> {
            System.out.printf("%s: %d%n", p.getKey(), p.getValue().size());
            p.getValue().stream().sorted(String::compareTo)
                    .forEach(s -> System.out.printf("-- %s%n", s));
        });
    }
}
