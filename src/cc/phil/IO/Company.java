package cc.phil.IO;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Department> departments;

    // Constructor
    //
    public Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    // Methodes
    //
    public void addDepartment(String nameOfNewDepartment) {
        if (departments.isEmpty()) {
            departments.add(new Department(nameOfNewDepartment));
            return;
        }

        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName().contains(nameOfNewDepartment)) {
                return;
            }
        }
        departments.add(new Department(nameOfNewDepartment));
    }

    public void setDepartmentSubdivision(String subDepartmentName, String departmentName) {
        for (Department department : departments) {
            // Test method here ..
            for (Department subDepartment : departments) {
                if (department.getName().equalsIgnoreCase(departmentName) &&
                        subDepartment.getName().equalsIgnoreCase(subDepartmentName)) {
                    if (!department.isSubDepartmentExist(subDepartmentName))
                        department.addSubDepartment(subDepartment);
                }
            }
        }
    }

    private boolean checkDepartmentHasSubdivision(Department department, String subDepartmentName) {
        boolean hasSubDepartment = false;

        for (Department sub : department.getSubDepartments()) {
            if (sub.getName().contains(subDepartmentName)) {
                hasSubDepartment = true;
                break;
            }
        }
        return hasSubDepartment;
    }

    public void checkDepartmentAndAddEmployee(String nameOfDepartment, Person newEmployee) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName().contains(nameOfDepartment)) {
                departments.get(i).addEmployee(newEmployee);
            }
        }
    }

    // Getter/Setter
    //
    public List<Department> getDepartments() {
        return departments;
    }
}
