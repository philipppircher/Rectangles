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

    public void setDepartmentSubdivision(String subDivisionName, String divisionName) {
        String subName = "";
        String divName = "";
        Department subDepartment = null;

        for (int i = 0; i < departments.size(); i++) {
            subName = departments.get(i).getName();

            if (subName.contains(subDivisionName)) {
                subDepartment = departments.get(i);
                break;
            }
        }


        for (int i = 0; i < departments.size(); i++) {
            divName = departments.get(i).getName();
            Department division = departments.get(i);

            if (divName.contains(divisionName) && !checkDepartmentHasSubdivision(division, subDepartment.getName())) {
                // Here is bug, fix it (Einkauf Europa, Einkauf Europa add as Child to parent)

                departments.get(i).addChildDepartment(subDepartment);
                return;
            }
        }
    }

    public boolean checkDepartmentHasSubdivision(Department department, String subDivisionName) {
        boolean hasSubdivision = false;

        for (Department sub : department.getSubDivisionDepartments()) {
            if (sub.getName().contains(subDivisionName)) {
                hasSubdivision = true;
                break;
            }
        }
        return hasSubdivision;
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
