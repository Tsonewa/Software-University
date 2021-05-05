package GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        for (int i = 0; i < items.length; i += 2) {
            String type = items[i];
            long amount = Long.parseLong(items[i + 1]);

            String item = setItem(type);

            if (item.equals("") || checkBagAvailability(bagCapacity, bag, amount)) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > getItemAmount(bag, "Gold") || getItemAmount(bag, item) + amount > getItemAmount(bag, "Gold")) {
                                continue;
                            } } }
                    break;
                case "Cash":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > getItemAmount(bag, "Gold") || getItemAmount(bag, item) + amount > getItemAmount(bag, "Gem")) {
                                continue;
                            } } }
                    break;
            }
            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<>());
            }

            if (!bag.get(item).containsKey(type)) {
                bag.get(item).put(type, 0L);
            }
            bag.get(item).put(type, bag.get(item).get(type) + amount);
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));
            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    private static long getItemAmount(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, String item){
        return bag.get(item).values().stream().mapToLong(e -> e).sum();
    }

    private static boolean checkBagAvailability(long bagCapacity, LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long amount) {
       return bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount;
    }

    private static String setItem(String name) {
        if (name.length() == 3) {
            return "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            return "Gold";
        }
        return "";
    }
}

