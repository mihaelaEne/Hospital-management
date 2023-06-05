package ro.mycode.view;

import ro.mycode.controller.PersonController;
import ro.mycode.model.Patient;
import ro.mycode.model.Person;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.Scanner;

public class ViewPerson {

    private Scanner scanner;
    private PersonController personController;

    public ViewPerson() {
        personController = new PersonController();
        scanner = new Scanner(System.in);
        play();

    }

    public void meniu() {
        System.out.println("Buna ziua!");
        System.out.println("Apasa tasta 1 pentru a afisa toate persoanele");
        System.out.println("Apasa tasta 2 pentru a adauga o persoana");
        System.out.println("Apasa tasta 3 pentru a sterge o persoana");
        System.out.println("Apasa tasta 4 pentru a salva si a te deloga");
    }

    public void play() {
        int alegere = 0;
        boolean running = true;

        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    personController.afisarePerson();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    removePerson();
                    break;
                case 4:
                    running=false;
                    personController.toSave();
                    break;

                default:
                    System.out.println("Alegere incorecta");
                    break;
            }
        }
    }

    private void addPerson() {
        System.out.println("Type:");
        String type = scanner.nextLine();
        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("LastName: ");
        String lastName = scanner.nextLine();
        System.out.println("FirstName:");
        String firstName = scanner.nextLine();
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        Person person = personController.findById(id);
        if (person == null) {
            Person person1 = new Person(type, id, lastName, firstName, age);
            personController.addPerson(person1);
        } else {
            System.out.println("Persoana exista deja");
        }

    }

    private void removePerson(){
        System.out.println("Id:");
        int id=Integer.parseInt(scanner.nextLine());
        Person person=personController.findById(id);
        if(person==null){
            System.out.println("Nu exista o persoan cu id-ul introdus");
        }else {
            personController.removePerson(person);
            System.out.println("Persoana a fost stearsa din lista ");
        }
    }

}
