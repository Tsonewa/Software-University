package CompanyRoaster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            Employee employee;

            if (input.length == 6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }else if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else {
            String emailOrAge = input[4];
            try {
                int currentAge = Integer.parseInt(emailOrAge);
                employee = new Employee(name, salary, position, department, currentAge);
            }catch (NumberFormatException e) {
                employee = new Employee(name, salary, position, department, emailOrAge);
            }
            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        Department maxAverage = departments.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().highestAverageSalary())).get().getValue();

        System.out.println("Highest Average Salary: " + maxAverage.getDepartment());
        maxAverage.getEmployees().stream()
                .sorted((e1, e2) ->Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

    }
}
