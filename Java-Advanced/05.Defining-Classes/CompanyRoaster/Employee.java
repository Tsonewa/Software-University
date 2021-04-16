package CompanyRoaster;

import org.w3c.dom.ls.LSOutput;

public class Employee {
    //name, salary, position, department, email and age
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee (String name, double salary, String position, String department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }


    public Employee (String name, double salary, String position, String department, String email){
        this(name, salary, position, department);
        this.email = email;
        this.age = -1;
    }
    public Employee (String name, double salary, String position, String department, String email, int age){
        this(name, salary, position, department, email);
        this.age = age;
    }
    public Employee (String name, double salary, String position, String department, int age){
        this(name, salary, position, department);
        this.age = age;
        this.email = "n/a";
    }
    public String toString (){
        //Ivan 840.20 ivan@ivan.com -1
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
