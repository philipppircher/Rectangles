package cc.phil.IO;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Person> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void recruiteEmployee(Person employee){
        employees.add(employee);
    }
}
