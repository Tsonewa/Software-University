import java.util.Scanner;

public class Graduation {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String name = scanner.nextLine();
        int counter = 0;
        double totalScore = 0;

        while(counter < 12){
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade >= 4){
                counter++;
                totalScore += grade;
            }
        }
        double avgGrade = totalScore / 12;
        System.out.printf("%s graduated. Average grade: %.2f", name, avgGrade);

    }
}
