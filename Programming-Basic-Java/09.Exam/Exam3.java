import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String country = scanner.nextLine(); //Russia", "Bulgaria" или "Italy
        String subject = scanner.nextLine(); //ribbon", "hoop" или "rope"
        double rateOne = 0;
        double rateTwo = 0;

        switch (country){
            case "Russia" :
                if (subject.equals("ribbon")){
                    rateOne += 9.100;
                    rateTwo += 9.400;
                }else if (subject.equals("hoop")){
                    rateOne += 9.300;
                    rateTwo += 9.800;
                }else if (subject.equals("rope")){
                    rateOne += 9.600;
                    rateTwo += 9.000;
                }
                break;
            case "Bulgaria" :
                if (subject.equals("ribbon")){
                    rateOne += 9.600;
                    rateTwo += 9.400;
                }else if (subject.equals("hoop")){
                    rateOne += 9.550;
                    rateTwo += 9.750;
                }else if (subject.equals("rope")){
                    rateOne += 9.500;
                    rateTwo += 9.400;
                }
                break;
            case "Italy" :
                if (subject.equals("ribbon")){
                    rateOne += 9.200;
                    rateTwo += 9.500;
                }else if (subject.equals("hoop")){
                    rateOne += 9.450;
                    rateTwo += 9.350;
                }else if (subject.equals("rope")){
                    rateOne += 9.700;
                    rateTwo += 9.150;
                }
                break;
        }
        double rate = rateOne + rateTwo;
        double total = 20 - rate;
        double purcentTotal = (total / 20) * 100;

        System.out.printf("The team of %s get %.3f on %s.%n", country, rate, subject);
        System.out.printf("%.2f%%", purcentTotal);

    }
}
