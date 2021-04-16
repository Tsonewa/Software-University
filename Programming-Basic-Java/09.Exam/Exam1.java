import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int yearsFee = Integer.parseInt(scanner.nextLine());

        double snickeers = yearsFee - (yearsFee * 0.4);
        double equipment = snickeers - (snickeers * 0.2);
        double ball = equipment / 4;
        double acsessoars = ball / 5;

        double sum =yearsFee + snickeers + equipment + ball + acsessoars;

        System.out.printf("%.2f", sum);

    }
}
