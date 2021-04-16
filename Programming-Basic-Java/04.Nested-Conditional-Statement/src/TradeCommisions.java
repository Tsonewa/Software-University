import java.util.Scanner;

public class TradeCommisions {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        if(sales >= 0 && sales <= 500) {
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", sales * 0.05);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", sales * 0.055);
                    break;
                case "Varna":
                    System.out.printf("%.2f", sales * 0.045);
                    break;
                    default: System.out.println("error");
                    break;
            }
        }else if (sales > 500 && sales <= 1000){
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", sales * 0.07);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", sales * 0.08);
                    break;
                case "Varna":
                    System.out.printf("%.2f", sales * 0.075);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }else if (sales > 1000 && sales <= 10000) {
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", sales * 0.08);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", sales * 0.12);
                    break;
                case "Varna":
                    System.out.printf("%.2f", sales * 0.1);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }else if (sales >= 10000){
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", sales * 0.12);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", sales * 0.145);
                    break;
                case "Varna":
                    System.out.printf("%.2f", sales * 0.13);
                    break;
                default:
                    System.out.println("error");
                    break; }
        }else {
            System.out.println("error");
        }
    }
}
