package StudentSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Exit")){
            String[] personInfo = input.split("\\s+");
            switch (personInfo[0]){
                case "Create":
                    Student student = new Student(personInfo[1], Integer.parseInt(personInfo[2]), Double.parseDouble(personInfo[3]));
                    Student.add(student);
                    break;
                case "Show":
                    String name = personInfo[1];
                    System.out.println(Student.commentary(name));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + personInfo[0]);
            }
            input = scanner.nextLine();
        }
        System.out.println();
    }
}
