package cc.phil.IO;

import java.io.*;

public class DepartmentMain {
    // Membervariables
    //
    public static void main(String[] args) {
        File file = new File("testdata/AbteilungenErweiterung.txt");
        Company company = new Company("MyCompany");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] lineArray = line.split(";");
                // First, create departments with names
                company.addDepartment(lineArray[1]);
                // Second, send employees to correct Department per Department name
                company.checkDepartmentAndAddEmployee(lineArray[1], new Person(lineArray[0]));
                // Third, addchildDepartments to parent Departments
                company.setDepartmentSubdivision(lineArray[1], lineArray[2]);
            }
        } catch (
                FileNotFoundException ex) {
            System.out.println("Datei nicht gefunden!");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}