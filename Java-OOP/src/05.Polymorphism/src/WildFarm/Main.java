package WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    while (!input.equals("End")){
        String[] animalData = input.split("\\s+");
        String[] foodData = scanner.nextLine().split("\\s+");

        Animal animal;
        Food food;

        switch (foodData[0]){
            case "Vegetable":
                food = new Vegetable(Integer.parseInt(foodData[1]));
                break;
            case "Meat":
                food = new Meat(Integer.parseInt(foodData[1]));
                break;
            default:
                throw new IllegalStateException("Unknown food type " + animalData[0]);
        }

        switch (animalData[0]){
            case "Cat":
                animal = new Cat(animalData[0], animalData[1],Double.parseDouble(animalData[2]), animalData[3], animalData[4]);
                break;
            case "Tiger":
                animal = new Tiger(animalData[0], animalData[1],Double.parseDouble(animalData[2]), animalData[3]);
                break;
            case "Zebra":
                animal = new Zebra(animalData[0], animalData[1],Double.parseDouble(animalData[2]), animalData[3]);
                break;
            case "Mouse":
                animal = new Mouse(animalData[0], animalData[1],Double.parseDouble(animalData[2]), animalData[3]);
                break;
            default:
                throw new IllegalStateException("Unknown switch statement" + animalData[0]);
        }
        animal.makeSound();

        try{
            animal.eat(food);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(animal.toString());
        input = scanner.nextLine();
    }
    }
}
