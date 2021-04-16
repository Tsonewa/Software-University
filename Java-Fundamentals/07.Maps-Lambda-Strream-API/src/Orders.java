import java.util.*;

public class Orders {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<Double>> products = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while(!input.equals("buy")) {
            String[] tokans = input.split("\\s+");
            String product = tokans[0];
            double price = Double.parseDouble(tokans[1]);
            double quantity = Double.parseDouble(tokans[2]);

            if (!products.containsKey(product)){
                products.putIfAbsent(product, new ArrayList<>());
                products.get(product).add(0, price);
                products.get(product).add(1, quantity);

            }else{

                double oldQualtity = products.get(product).get(1);
                products.get(product).set(1, oldQualtity + quantity);

                double oldPrice = products.get(product).get(0);
                if (oldPrice != price){
                    products.get(product).set(0, price);
                }
                products.get(product).set(0, price);
            }

            input = scanner.nextLine();
        }
        products.entrySet()
                .stream()
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), (e.getValue().get(0) * e.getValue().get(1))));
    }
}