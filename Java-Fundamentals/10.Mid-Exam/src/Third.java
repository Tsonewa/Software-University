import java.util.*;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, ArrayList<Integer>> towns = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Sail")) {
            String[] tokans = input.split("\\|\\|");
            String town = tokans[0];
            int population = Integer.parseInt(tokans[1]);
            int gold = Integer.parseInt(tokans[2]);

            if (!towns.containsKey(town)) {
                towns.putIfAbsent(town, new ArrayList<>());
                towns.get(town).add(0, population);
                towns.get(town).add(1, gold);
            }else {
                int countPeople = towns.get(town).get(0);
                int countGold = towns.get(town).get(1);
                towns.get(town).add(0, countPeople + population);
                towns.get(town).add(1, countGold + gold);
            }
            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("End")) {
            String[] commands = secondInput.split("\\=\\>");
            String command = commands[0];
            String townName = commands[1];

            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(commands[2]);
                    int golds = Integer.parseInt(commands[3]);

                    int townPopulation = towns.get(townName).get(0);
                    towns.get(townName).set(0, townPopulation - people);
                    int townGold = towns.get(townName).get(1);
                    towns.get(townName).set(1, townGold - golds);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", townName, golds, people);

                    if (towns.get(townName).get(0) <= 0 || towns.get(townName).get(1) <= 0) {
                        towns.remove(townName);
                        System.out.printf("%s has been wiped off the map!%n", townName);
                    }
                    break;
                case "Prosper":
                    int gold = Integer.parseInt(commands[2]);
                    if (gold < 0) {
                        System.out.printf("Gold added cannot be a negative number!%n");
                        break;
                    } else {
                        int oldGold = towns.get(townName).get(1);
                        towns.get(townName).set(1, oldGold + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, townName, towns.get(townName).get(1));
                    }
                    break;
            }
            secondInput = scanner.nextLine();
        }
        int usersCount = towns.size();
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", usersCount);

        towns
                .entrySet()
                .stream()
                .sorted((e1,e2) -> {
                    int first = e1.getValue().get(1);
                    int second = e2.getValue().get(1);
                    int result = Integer.compare(second, first);
                    return result;
                })

                .forEach((e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        e.getKey(),e.getValue().get(0), e.getValue().get(1))));

    }
}


