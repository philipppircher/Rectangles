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
                // First create departments with names
                company.addDepartment(lineArray[1]);
                // Person names
                Person employee = new Person(lineArray[0]);
                // Send employee to correct Department per Department name
                //company.checkDepartmentAndAddEmployee(lineArray[1], employee);
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