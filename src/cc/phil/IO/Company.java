package cc.phil.IO;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Department>departments;

    // Constructor
    //
    public Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
        setDepartments();
    }

    // Methodes
    //
    private void setDepartments(){
        departments.add(new Department("Vorstand"));
        departments.add(new Department("Einkauf"));
        departments.add(new Department("Einkauf Europa"));
        departments.add(new Department("Einkauf Italien"));
        departments.add(new Department("Einkauf USA"));
        departments.add(new Department("Vertrieb"));
        departments.add(new Department("Vertrieb Europa"));
        addChildDepartments();
    }

    private void addChildDepartments(){
        departments.get(0).addChildDepartment(departments.get(1));   // Einkauf -> Vorstand
        departments.get(0).addChildDepartment(departments.get(5));   // Vertrieb -> Vorstand
        departments.get(1).addChildDepartment(departments.get(2));   // Einkauf Europa -> Einkauf
        departments.get(1).addChildDepartment(departments.get(4));   // Einkauf USA -> Einkauf
        departments.get(2).addChildDepartment(departments.get(3));   // Einkauf Italien -> Einkauf Europa
        departments.get(5).addChildDepartment(departments.get(6));   // Vertrieb Europa -> Vertrieb
    }

    public void checkDepartmentAndAddEmployee(String line, Person employee) {
        for (Department department : departments) {
            if (department.getName().equals(line)){
                department.recruiteEmployee(employee);
            }
        }
    }

    // Getter/Setter
    //
    public List<Department> getDepartments() {
        return departments;
    }
}
