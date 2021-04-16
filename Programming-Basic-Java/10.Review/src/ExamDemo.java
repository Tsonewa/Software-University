import java.util.Scanner;

public class ExamDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double actualPlumber = 0;

        for (int day = 1; day <= days; day++) {
            actualPlumber += dailyPlunder;

        if(day % 3 == 0){
            actualPlumber += dailyPlunder * 0.5;
        }
        if (day % 5 == 0){
            actualPlumber -= actualPlumber * 0.3;
        }
        }
        if (expectedPlunder <= actualPlumber){
            System.out.printf("Ahoy! %.2f plunder gained.", actualPlumber);
        }else {
            double percantage = (actualPlumber / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percantage);
        }
    }
}
