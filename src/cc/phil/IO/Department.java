package cc.phil.IO;

import java.util.ArrayList;
import java.util.List;

public class Department {
    // Membervariables
    //
    private String name;
    private List<Person> employees;
    private ArrayList<Department> childDepartments;

    // Constructor
    //
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.childDepartments = new ArrayList<>();
    }

    public Department(Person employee){
        this.employees.add(employee);
    }

    // Methodes
    //
    public void recruiteEmployee(Person employee){
        employees.add(employee);
    }

    // Getter/Setter
    //
    public void addChildDepartment(Department department){
        this.childDepartments.add(department);
    }

    public String getName() {
        return name;
    }
}