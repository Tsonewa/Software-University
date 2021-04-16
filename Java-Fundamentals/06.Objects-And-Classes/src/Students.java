import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    private static class Student{
        //John Smith 15 Sofia
        String firstName;
        String secondName;
        int age;
        String homeTown;

        private String getFirstName(){
            return firstName;
        }
        private String getSecondName(){
            return secondName;
        }
        private int getAge(){
            return age;
        }
        private String getHomeTown(){
            return homeTown;
        }
        private void setFirstName(String firstName){
            this.firstName = firstName;
        }
        private void setSecondName(String secondName){
            this.secondName = secondName;
        }
        private void setAge(int age){
            this.age = age;
        }
        private void setHomeTown(String homeTown){
            this.homeTown = homeTown;
        }
        public Student(String firstName, String secondName, int age, String homeTown){
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.homeTown = homeTown;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line =scanner.nextLine();

        List<Student> students = new ArrayList<>();
        while (!line.equals("end")){
            String[] parts = line.split(" ");

            String firstName = parts[0];
            String secondName = parts[1];
            int age = Integer.parseInt(parts[2]);
            String homeTown = parts[3];

            Student student = new Student(firstName,secondName, age, homeTown);
            students.add(student);
            line = scanner.nextLine();
        }
        String town = scanner.nextLine();
        for (Student student: students) {
            if (student.getHomeTown().equals(town)){
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getSecondName(),student.getAge());
            }
        }
    }
}
