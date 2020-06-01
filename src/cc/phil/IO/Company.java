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


    // Getter/Setter
    //
    public List<Department> getDepartments() {
        return departments;
    }
}
