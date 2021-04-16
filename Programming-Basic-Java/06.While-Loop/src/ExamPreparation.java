import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int maxPoorGrades = Integer.parseInt(scanner.nextLine());
        String task = scanner.nextLine();
        int numberPoorGrades = 0;
        int sumGrade = 0;
        int numberOfTask = 0;
        String lastTask = "";

        while (!task.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());
            sumGrade += grade;
            numberOfTask++;
            if (grade <= 4) {
                numberPoorGrades++;
            }
            if (numberPoorGrades == maxPoorGrades) {
                System.out.printf("You need a break, %d poor grades.", numberPoorGrades);
                break;
            }
            lastTask = task;
            task = scanner.nextLine();

        }
        double average = sumGrade * 1.0 / numberOfTask;
        if (task.equals("Enough")) {
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Number of problems: %d%n", numberOfTask);
            System.out.printf("Last problem: %s", lastTask);
        }
    }
}