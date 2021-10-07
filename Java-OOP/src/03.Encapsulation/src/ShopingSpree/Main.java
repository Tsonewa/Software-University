package ShopingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        //Read people
        String[] input = scanner.nextLine().split(";");
        for (int i = 0; i < input.length; i++) {
            String[] tokans = input[i].split("=");
            try {
                people.add(new Person(tokans[0], Double.parseDouble(tokans[1])));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        //Read products
        String[] secondLine = scanner.nextLine().split(";");
        for (int i = 0; i < secondLine.length; i++) {
            String[] tokan = secondLine[i].split("=");
            try {
                products.add(new Product(tokan[0], Double.parseDouble(tokan[1])));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        String command = scanner.nextLine();
        Map<String, List<String>> result = new TreeMap<>();
        while (!command.equals("END")){
            String[] productToBuy = command.split("\\s+");
            String name = productToBuy[0];
            String productName = productToBuy[1];

            for (Person person : people) {
                if (person.getName().equals(name)) {
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            try {
                                person.buyProduct(product);
                                result.putIfAbsent(person.getName(), new ArrayList<>());
                                result.get(person.getName()).add(product.getName());
                                System.out.printf("%s bought %s%n", person.getName(), product.getName());
                            } catch (IllegalArgumentException ex) {
                                result.putIfAbsent(person.getName(), new ArrayList<>());
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }

       result.entrySet().stream().forEach(entry -> {
           if (entry.getValue().isEmpty()){
               System.out.printf("%s - Nothing bought%n", entry.getKey());
           } else {
               System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
           }
       });
    }
}
