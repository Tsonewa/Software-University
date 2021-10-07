package Animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        String className = scanner.nextLine();

        while (!className.equals("Beast!")){
            String[] data = scanner.nextLine().split("\\s+");

            switch (className){
                case "Cat":
                    try {
                        Cat cat = new Cat(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.println(cat.toString());
                        break;
                    }catch (Exception error){
                        System.out.println(error.getMessage());
                        break;
                    }
                case "Frog":
                    try {
                        Frog frog = new Frog(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.println(frog.toString());
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case "Dog":
                    try {
                        Dog dog = new Dog(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.println(dog.toString());
                        break;
                    }catch (Exception error){
                        System.out.println(error.getMessage());
                        break;
                    }
                case "Tomcat":
                    try {
                        Tomcat tomcat = new Tomcat(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.println(tomcat.toString());
                        break;
                    }catch (Exception error){
                        System.out.println(error.getMessage());
                        break;
                    }
                case "Kitten":
                    try {
                        Kitten kitten = new Kitten(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.println(kitten.toString());
                        break;
                    }catch (Exception error){
                        System.out.println(error.getMessage());
                        break;
                    }
            }
            className = scanner.nextLine();
        }
    }
}
