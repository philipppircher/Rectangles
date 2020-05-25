package cc.phil.IO;

import java.io.*;

public class DepartmentMain {
    // Membervariables
    //
    private static Department management = new Department("Vorstand");
    private static Department buyingDepartment = new Department("Einkauf");
    private static Department buyingDepartmentEurope = new Department("Einkauf Europa");
    private static Department buyingDepartmentItaly = new Department("Einkauf Italien");
    private static Department buyingDepartmentUSA = new Department("Einkauf USA");
    private static Department distribution = new Department("Vertrieb");
    private static Department distributionEU = new Department("Vertrieb Europa");

    public static void main(String[] args) {
        File file = new File("testdata/Abteilungen.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(";");
                // Person names
                Person employee = new Person(lineArray[0]);
                // Send employee to correct Department per Department name
                checkDepartmentAndAddEmployee(lineArray[1], employee);
            };
        } catch (FileNotFoundException ex) {
            System.out.println("Datei nicht gefunden!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkDepartmentAndAddEmployee(String line, Person employee) {
        switch (line) {
            case "Vorstand":
                management.recruiteEmployee(employee);
                break;
            case "Einkauf":
                buyingDepartment.recruiteEmployee(employee);
                break;
            case "Einkauf Europa":
                buyingDepartmentEurope.recruiteEmployee(employee);
                break;
            case "Einkauf Italien":
                buyingDepartmentItaly.recruiteEmployee(employee);
                break;
            case "Einkauf USA":
                buyingDepartmentUSA.recruiteEmployee(employee);
                break;
            case "Vertrieb":
                distribution.recruiteEmployee(employee);
                break;
            case "Vertrieb Europa":
                distributionEU.recruiteEmployee(employee);
                break;
        }
    }
}