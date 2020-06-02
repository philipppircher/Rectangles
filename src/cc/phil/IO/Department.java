package cc.phil.IO;

import java.util.ArrayList;
import java.util.List;

public class Department {
    // Membervariables
    //
    private String name;
    private List<Person> employees;
    private ArrayList<Department> subDivisionDepartments;

    // Constructor
    //
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.subDivisionDepartments = new ArrayList<>();
    }

    public Department(Person employee){
        this.employees.add(employee);
    }

    // Methodes
    //
    public void addEmployee(Person employee){
        employees.add(employee);
    }

    // Getter/Setter
    //
    public void addChildDepartment(Department department){
        this.subDivisionDepartments.add(department);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Department> getSubDivisionDepartments() {
        return subDivisionDepartments;
    }
}