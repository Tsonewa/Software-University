package StudentSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private double grade;
    private static List<Student> students = new ArrayList<>();

    public Student(String name, int age, double grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public static void add(Student student){
        students.add(student);
    }

    public static String commentary(String name){
        Student student = students.stream().filter(s-> s.getName().equals(name)).findFirst().get();
        if (student.getGrade() >= 5.50 && student.getGrade() <= 6.00){
            return student.toString() + "Excellent student.";
        }else if (student.getGrade() >= 4.50 && student.getGrade() < 5.50){
            return student.toString() + "Average student.";
        }else {
            return student.toString() + "Poor student.";
        }
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString(){
        return String.format("%s is %d years old. ", getName(), getAge());
    }
}
