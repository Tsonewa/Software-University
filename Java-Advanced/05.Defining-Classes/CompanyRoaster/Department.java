package CompanyRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String department;
    private List<Employee> employees;

public Department (String department){
    this.department = department;
    this.employees = new ArrayList<>();
}

    public List<Employee> getEmployees() {
        return employees;
    }
    public double highestAverageSalary (){
    return this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public String getDepartment() {
        return department;
    }

}
