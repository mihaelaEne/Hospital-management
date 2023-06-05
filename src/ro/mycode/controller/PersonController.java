package ro.mycode.controller;

import ro.mycode.model.Doctor;
import ro.mycode.model.Patient;
import ro.mycode.model.Person;

import java.awt.event.TextEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonController {

    private Scanner scanner;
    private ArrayList<Person> people;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public PersonController(ArrayList<Person> people) {
        this.people = people;
    }

    public PersonController() {
        this.people = new ArrayList<>();
        this.load();
    }


    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\Hospital-Management\\src\\ro\\mycode\\data\\person.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                switch (text.split(",")[0]) {
                    case "Doctor":
                        this.people.add(new Doctor(text));
                        break;
                    case "Patient":
                        this.people.add(new Patient(text));
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void afisarePerson(){
        for(int i=0; i<people.size();i++){
            System.out.println(this.people.get(i));
            System.out.println("\n");
        }
    }

    public void addPerson(Person person){
        this.people.add(person);
    }


    public void removePerson(Person person){
        this.people.remove(person);
    }


    public Person findById(int id){
        for(int i=0; i<people.size();i++){
            if(people.get(i).getId()==id){
                return people.get(i);
            }
        }
        return null;
    }


    public String toSave(){
        String text="";
        for(int i=0; i<people.size();i++) {
        Person person=(Person)people.get(i);
        text+=person.toSave()+"\n";
        }
        return text;

    }

    public void save(){
        try {
            File file=new File("C:\\mycode\\OOP\\Hospital-Management\\src\\ro\\mycode\\data\\person.txt");
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
