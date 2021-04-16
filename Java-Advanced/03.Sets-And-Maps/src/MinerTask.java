import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> resorces = new LinkedHashMap<>();
        String material = scanner.nextLine();

        while (!material.equals("stop")){
            int amount = Integer.parseInt(scanner.nextLine());
            resorces.putIfAbsent(material,0);
            resorces.put(material, resorces.get(material) + amount);

            material = scanner.nextLine();
        }
        resorces.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
                });
    }
}
