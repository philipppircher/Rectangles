package cc.phil.IO;

import java.util.ArrayList;
import java.util.List;

public class Department {
    // Membervariables
    //
    private String name;
    private List<Person> employees;
    private ArrayList<Department> subDepartments;

    // Constructor
    //
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.subDepartments = new ArrayList<>();
    }

    public Department(Person employee) {
        this.employees.add(employee);
    }

    // Methodes
    //
    public void addEmployee(Person employee) {
        employees.add(employee);
    }

    // Getter/Setter
    //
    public void addSubDepartment(Department department) {
        this.subDepartments.add(department);
    }

    public boolean isSubDepartmentExist(String dep) {
        if (subDepartments.size() > 0) {
            for (Department department : subDepartments) {
                if (department.getName().equalsIgnoreCase(dep)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Department> getSubDepartments() {
        return subDepartments;
    }
}