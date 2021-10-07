package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String className = tokens[0];

            switch (className){
                case "Citizen":
                    birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Pet":
                    birthables.add(new Pet(tokens[1], tokens[2]));
                    break;
                case "Robot":
                    birthables.add(new Robot(tokens[1], tokens[2]));
                    break;
            }
            input = scanner.nextLine();
        }

        String postfix = scanner.nextLine();
        for (Birthable b: birthables) {
            if(b.getBirthDate().endsWith(postfix)){
                System.out.println(b.getBirthDate());
            }
        }
    }
}
