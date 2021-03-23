package ro.java.ctrln.program;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SimulateLogging {

    public static void main(String[] args) {
        Person[] persons = new Person[5];
        int index = 0;

        try (Scanner scanner = new Scanner((new FileInputStream("persons.txt")))) {
            while (scanner.hasNext()) {
                String personLine = scanner.nextLine();
                String[] personLineComponents = personLine.split("\\|");
                System.out.println("Linia citita este: " + personLine);
                for (int i = 0; i < personLineComponents.length; i++) {
                    System.out.println("\tComponenta " + i + " este: " + personLineComponents[i]);
                }
                int personAge = "".equals(personLineComponents[2]) ? 0 : Integer.parseInt(personLineComponents[2]);
                String job = personLineComponents.length == 4 ? personLineComponents[3] : "";
                Person person = new Person(personLineComponents[0], personLineComponents[1], personAge, job);
                System.out.println("Persoana scanata este: " + person);
                persons[index] = person;
                index++;
            }
        } catch (IOException ioe) {
            System.out.println("A aparut IOException");
        } catch (NumberFormatException nfe) {
            System.out.println("A aparut o exceptie");
        }

        Path path = Paths.get("persons-output-" + System.currentTimeMillis() + ".txt");
        for (Person person : persons) {
            try {
                if (person.getAge() == 0) {
                    throw new PersonException("Varsta nu este corespunzatoare!");
                }
                Files.write(path,person.toString().getBytes());
            } catch (PersonException pe) {
                System.out.println("A aparut exceptia: " + pe.getMessage());
            } catch (IOException ioe) {
                System.out.println("A aparut IOException");
                ioe.printStackTrace();
            }
        }
    }
}