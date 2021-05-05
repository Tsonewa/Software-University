import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductsShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //"Revision" command you will receive an input in the format: "{shop}, {product}, {price}"

        String input = scanner.nextLine();
        Map<String, Map<String,Double>> data = new TreeMap<>();

        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            data.putIfAbsent(shop, new LinkedHashMap<>());
            data.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        //{shop}->
        //Product: {product}, Price: {price}

        data.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + "->");
            entry.getValue().entrySet().forEach(innerElement ->{
                System.out.printf("Product: %s, Price: %.1f%n", innerElement.getKey(), innerElement.getValue());
            });
        });
    }
}
