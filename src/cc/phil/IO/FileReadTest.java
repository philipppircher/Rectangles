package cc.phil.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadTest {
    public static void main(String[] args) {
        File file = new File("testdata/people.txt");
        List<Person> people = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] lineArray= line.split(";");
                Person person = new Person(lineArray[0], lineArray[1], lineArray[2]);
                people.add(person);
            }

            for (Person person : people) {
                System.out.println(person.toString());
            }
           /* int character;
            while ((character = fileReader.read()) != - 1){
                System.out.print(Character.toString(character));
            };*/
        } catch (FileNotFoundException e) {
            System.out.print("Ihr File ist nicht vorhanden!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
