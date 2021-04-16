import java.util.Scanner;

public class ForeighLanguage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String country = scanner.nextLine();

        switch (country){
            case "USA":
                case "England":
                    System.out.println("English");
                    break;
            case "Spain":
            case "Argentina":
                case "Mexico":
                System.out.println("Spanish");
                break;
default:
    System.out.println("unknown");
    break;
        }
    }
}
