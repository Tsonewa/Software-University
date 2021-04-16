import java.util.Scanner;

public class GraduationTwo {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String name = scanner.nextLine();
        int classCounter = 1;
        double totalScore = 0;
        int fails = 0;

        while(classCounter <= 12) {
            if (fails > 1) {
                System.out.printf("%s has been excluded at %d grade", name, classCounter);
                break;
            }
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 4) {
                classCounter++;
                totalScore += grade;
            } else {
                fails++;
            }
        }
            if (fails <= 1) {
                double avgGrade = totalScore / 12;
                System.out.printf("%s graduated. Average grade: %.2f", name, avgGrade);
            }
        }

    }
