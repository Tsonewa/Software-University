import java.util.Scanner;

public class AnimalKind {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String animal=scanner.nextLine();

        switch(animal) {
            case "dog" :
                System.out.print("mammal");
                break;
            case "crocodile":
                System.out.print("reptile");
                break;
            case "tortoise" :
                System.out.print("reptile");
                break;
            case "snake":
                System.out.print("reptile");
                break;
            case "cat" :
                System.out.print("unknown");
                break;
        }
    }
}
