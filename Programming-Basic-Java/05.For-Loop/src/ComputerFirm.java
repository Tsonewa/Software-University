import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        double countSales = 0;
        double averagerate = 0;
        int countRate = 0;

        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            char rate = input.charAt(2);
            String rateing = rate + "";
            int rateingt = Integer.parseInt(rateing);
            char sold = input.charAt(0);
            char soldtwo = input.charAt(1);
            String soldNumber = sold + "" + soldtwo;
            double sales = Double.parseDouble(soldNumber);

            if (rateingt == 2) {
                averagerate += 2;
                countRate++;
            } else if (rateingt == 3){
                sales = sales - (sales * 0.5);
                countSales += sales;
                averagerate += 3;
                countRate++;
        } else if (rateingt== 4) {
                sales = sales - (sales * 0.3);
                countSales += sales;
                averagerate += 4;
                countRate++;
            }else if (rateingt == 5) {
                sales = sales - (sales * 0.15);
                countSales += sales;
                averagerate += 5;
                countRate++;
            }else if (rateingt == 6){
                countSales += sales;
                averagerate += 6;
                countRate++;
            }
        }
        double averageRaiting = averagerate / countRate;
        System.out.printf("%.2f%n",countSales);
        System.out.printf("%.2f",averageRaiting);
    }
}
