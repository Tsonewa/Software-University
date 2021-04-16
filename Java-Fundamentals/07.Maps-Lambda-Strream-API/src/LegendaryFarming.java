import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> keyItems = new LinkedHashMap<>();
        keyItems.put("shards", 0);
        keyItems.put("motes", 0);
        keyItems.put("fragments", 0);

        TreeMap<String, Integer> junk = new TreeMap<>();
        String[] input = scanner.nextLine().split("\\s+");
        boolean isObtained = false;
        String obtain = "";

        while (!isObtained){

            for (int i = 0; i < input.length; i+= 2) {
                int quantity = Integer.parseInt(input[i]);
                String item = input[i + 1].toLowerCase();

                if(keyItems.containsKey(item)){
                    int oldQuantity = keyItems.get(item);
                    keyItems.put(item, oldQuantity + quantity);

                    if (keyItems.get(item) >= 250){
                        int old = keyItems.get(item);
                        keyItems.put(item, old - 250);
                        isObtained = true;

                        switch (item){
                            case "motes":
                                obtain = "Dragonwrath";
                                break;
                            case "shards":
                                obtain = "Shadowmourne";
                                break;
                            case "fragments":
                                obtain = "Valanyr";
                                break;
                        }
                        break;
                    }

                }else {
                    junk.putIfAbsent(item, 0);
                    int oldQuanty = junk.get(item);
                    junk.put(item, oldQuanty + quantity);
                }
            }
            if (isObtained){
                break;
            }
            input = scanner.nextLine().split("\\s+");
        }

        System.out.printf("%s obtained!%n", obtain);

        keyItems.entrySet()
                .stream()
                .sorted((i1,i2) -> {
                    int item1 = i1.getValue();
                    int item2 = i2.getValue();
                    String itemN = i1.getKey();
                    String item2N = i2.getKey();

                    if (item1 == item2){
                        return (itemN.compareTo(item2N));
                    }
                    return Integer.compare(item2, item1);
                })
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));

        junk.entrySet()
                .stream()
                .forEach(j -> System.out.printf("%s: %d%n", j.getKey(), j.getValue()));
    }
}