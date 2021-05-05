import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class StudentsSecondEdition {

    static class Students {
        String name;
        String surName;
        double age;

        public Students(String name, String surName, double age) {
            this.name = name;
            this.surName = surName;
            this.age = age;
        }

        public double getAge() {
            return this.age;
        }

        //"{first name} {second name}: {grade}"
        @Override
        public String toString() {
            return String.format("%s %s: %.2f", name, surName, age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] studentInformation = scanner.nextLine().split(" ");
            String name = studentInformation[0];
            String surName = studentInformation[1];
            double age = Double.parseDouble(studentInformation[2]);
            Students students = new Students(name, surName, age);
            studentsList.add(students);
        }
        studentsList.sort(Comparator.comparingDouble(Students::getAge).reversed());
        for (Students student : studentsList) {
            System.out.println(student.toString());
        }
    }
}