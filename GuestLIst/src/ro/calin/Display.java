package ro.calin;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Display implements Serializable{
    private GuestList eveniment;
    private final Scanner sc = new Scanner(System.in);
    private static final long serialVersionUID = 1L;

    public Display(String numeEveniment, int nrTotalLocuri) {
        this.eveniment = new GuestList(numeEveniment, nrTotalLocuri);
    }

    public void start() throws IOException {
//        this.add("Stanciu","Robert","srobert@gmail.com","0744567890");
//        this.add("Popescu","Vlad","vpopescu@gmail.com","0744567891");
//        this.add("Cucu","Rucu","rcucu@gmail.com","0744567892");
//        this.add("Tanase","Elena","telena@gmail.com","0744567893");
        try(ObjectInputStream inputStreamFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("output.dat")))){
            this.eveniment = (GuestList) inputStreamFile.readObject();
        } catch (ClassNotFoundException e){
            System.out.println("class not found" + e.getMessage());
        }


        boolean quit = false;
        while (!quit) {
            System.out.println("\nadd          - Adauga o noua persoana (inscriere)\n" +
                    "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                    "remove       - Sterge o persoana existenta din lista\n" +
                    "update       - Actualizeaza detaliile unei persoane\n" +
                    "guests       - Lista de persoane care participa la eveniment\n" +
                    "waitlist     - Persoanele din lista de asteptare\n" +
                    "available    - Numarul de locuri libere\n" +
                    "guests_no    - Numarul de persoane care participa la eveniment\n" +
                    "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                    "subscribe_no - Numarul total de persoane inscrise\n" +
                    "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                    "quit         - Inchide aplicatia\n");
            String nextAction = sc.nextLine();
            switch(nextAction) {
                case "add":
                    System.out.print("Introduceti numele de familie"); String lastName = sc.nextLine();
                    System.out.print("Introduceti prenumele"); String firstName = sc.nextLine();
                    System.out.print("Introduceti emailul"); String email = sc.nextLine();
                    System.out.print("Introduceti numarul de Telefon"); String telephoneNumber = sc.nextLine();
                    try {
                        this.add(lastName, firstName, email, telephoneNumber);
                    } catch (Errors.AlreadyOnList e){
                        System.out.println("Participantul este deja inscris");
                    } finally {
                        break;
                    }
                case "guests":
                    this.guests();
                    break;
                case "waitlist":
                    this.waitlist();
                    break;
                case "quit":
                    try(ObjectOutputStream fileout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("output.dat")))){
                        fileout.writeObject(this.eveniment);
                    }
                    quit = true;
                    break;
                case "available":
                    this.available();
                    break;
                case "waitlist_no":
                    this.waitlist_no();
                    break;
                case "subscribe_no":
                    this.subscribe_no();
                    break;
                case "guests_no" :
                    this.guests_no();
                    break;
                case "check":
                    try {
                        this.check();
                    }catch (Errors.AlreadyOnList e){
                        System.out.println("Participantul este deja pe lista");
                    }catch (Errors.NotFound e){
                        System.out.println("Participantul nu a fost gasit");
                    } finally {
                        break;
                    }
                case "remove":
                    try{
                        this.remove();
                    } catch (Errors.NotFound e){
                        System.out.println("Participantul nu a fost gasit");
                    }finally {
                        break;
                    }
                case "update":
                    this.update();
                    break;
                case "search":
                    System.out.print("Introduceti cuvantul cheie al cautarii: ");
                    String key = sc.nextLine();
                    this.search(key);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private void guests() {
        if(this.eveniment.getListaParticipanti().size() == 0) {
            System.out.println("Lista este goala");
        }
        for (int i = 0; i < this.eveniment.getListaParticipanti().size(); i++) {
            System.out.println((i + 1) + ". " + this.eveniment.getListaParticipanti().get(i));
        }
    }

    private void waitlist() {
        if(this.eveniment.getListaAsteptare().size() == 0) {
            System.out.println("Lista este goala");
        }
        for (int i = 0; i < this.eveniment.getListaAsteptare().size(); i++) {
            System.out.println((i + 1) + ". " + this.eveniment.getListaAsteptare().get(i));
        }
    }

    private void search(String key) {
        ArrayList<Guest> searchList = eveniment.partialSearchArr(key);
        for (int i = 0; i < searchList.size(); i++) {
            Guest guest = searchList.get(i);
            System.out.println("Contact " + (i + 1) + ": Contine " +
                    (guest.getLastName().contains(key) ? " Nume = " + guest.getLastName() : "") +
                    (guest.getFirstName().contains(key) ? "| Prenume = " + guest.getFirstName() : "") +
                    (guest.getEmail().contains(key) ? "| email = " + guest.getEmail() : "") +
                    (guest.getPhoneNumber().contains(key) ? "| Telefon = " + guest.getPhoneNumber() : ""));
        }
    }

    private void add(String lastName, String firstName, String email, String phoneNumber) throws Errors.AlreadyOnList {
        int atl = this.eveniment.addToList(lastName, firstName, email, phoneNumber);
        if (atl < 0) {
            throw new Errors.AlreadyOnList();                                                        // error
        } else if (atl == 0) {
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
        } else {
        System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " +
                +(atl) + ". Te vom notifica daca un loc devine disponibil");
        }
    }

    private void check() throws Errors.AlreadyOnList, Errors.NotFound {
        System.out.println("Cautati persoana dupa: (1) Nume/Prenume    (2) email  (3) Numar telefon");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.print("Introduceti numele si prenumele: ");
                String lastName = sc.next();
                String firstName = sc.next();
                sc.nextLine();
                if (eveniment.checkByName(lastName, firstName) == -2) {
                    throw new Errors.NotFound();                                                 // error
                } else if (eveniment.checkByName(lastName, firstName) == -1) {
                    throw new Errors.AlreadyOnList();                                              // error
                } else {
                    System.out.println("Esti pe lista de asteptare cu numarul de ordine "
                            + (eveniment.checkByName(lastName, firstName) + 1));
                }
                break;
            case 2:
                System.out.print("Introduceti adresa de email: ");
                String email = sc.next();
                sc.nextLine();
                if (eveniment.checkByEmail(email) == -2) {
                    throw new Errors.NotFound();                                                         // error
                } else if (eveniment.checkByEmail(email) == -1) {
                    throw new Errors.AlreadyOnList();                                                    // error
                } else {
                    System.out.println("Esti pe lista de asteptare cu numarul de ordine "
                            + (eveniment.checkByEmail(email) + 1));
                }
                break;
            case 3:
                System.out.print("Introduceti numarul de telefon: ");
                String phoneNumber = sc.next();
                sc.nextLine();
                if (eveniment.checkByPhoneNumber(phoneNumber) == -2) {
                    throw new Errors.NotFound();                                                         // error
                } else if (eveniment.checkByPhoneNumber(phoneNumber) == -1) {
                    throw new Errors.AlreadyOnList();                                                    // error
                } else {
                    System.out.println("Esti pe lista de asteptare cu numarul de ordine "
                            + (eveniment.checkByPhoneNumber(phoneNumber) + 1));
                }
                break;
            default:
                System.out.println("Optiune invalida!");
                break;
        }
    }

    private void remove() throws Errors.NotFound {
        System.out.println("Cautati persoana dupa: (1) Nume/Prenume    (2) email  (3) Numar telefon");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.print("Introduceti numele si prenumele: ");
                String lastName = sc.next();
                String firstName = sc.next();
                sc.nextLine();
                if (eveniment.removeByName(lastName, firstName)) {
                    int x = eveniment.getListaParticipanti().size();
                    System.out.println("Participantul a fost sters din lista de participanti cu succes");
                    if (eveniment.getListaParticipanti().size() == x) {
                        System.out.println("Felicitari " + eveniment.getListaParticipanti().get(x - 1).getLastName() +
                                " ai fost transferat/a de pe lista de asteptare, pe lista de participanti!");
                    }
                } else {
                    throw new Errors.NotFound();                                                      // error
                }
                break;
            case 2:
                System.out.print("Introduceti adresa de email: ");
                String email = sc.next();
                sc.nextLine();
                if (eveniment.removeByEmail(email)) {
                    int x = eveniment.getListaParticipanti().size();
                    System.out.println("Participantul a fost sters din lista de participanti cu succes");
                    if (eveniment.getListaParticipanti().size() == x) {
                        System.out.println("Felicitari " + eveniment.getListaParticipanti().get(x - 1).getLastName() +
                                " ai fost transferat/a de pe lista de asteptare, pe lista de participanti!");
                    }
                } else {
                    throw new Errors.NotFound();                                                         // error
                }
                break;
            case 3:
                System.out.print("Introduceti numarul de telefon: ");
                String phoneNumber = sc.next();
                sc.nextLine();
                if (eveniment.removeByPhoneNumber(phoneNumber)) {
                    int x = eveniment.getListaParticipanti().size();
                    System.out.println("Participantul a fost sters din lista de participanti cu succes");
                    if (eveniment.getListaParticipanti().size() == x) {
                        System.out.println("Felicitari " + eveniment.getListaParticipanti().get(x - 1).getLastName() +
                                " ai fost transferat/a de pe lista de asteptare, pe lista de participanti!");
                    }
                } else {
                    throw new Errors.NotFound();
                }
                break;
            default:
                System.out.println("Optiune invalida!");
                break;
        }
    }

    public void update() {
        System.out.println("Cautati persoana dupa: (1) Nume/Prenume    (2) email  (3) Numar telefon");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.print("Introduceti numele si prenumele: ");
                String lastName = sc.next();
                String firstName = sc.next();
                sc.nextLine();
                Guest guest = eveniment.searchByName(lastName, firstName);
                modify(guest);
                break;
            case 2:
                System.out.print("Introduceti adresa de email: ");
                String email = sc.next();
                sc.nextLine();
                Guest guest2 = eveniment.searchByEmail(email);
                modify(guest2);
                break;
            case 3:
                System.out.print("Introduceti numarul de telefon: ");
                String phoneNumber = sc.next();
                sc.nextLine();
                Guest guest3 = eveniment.searchByPhoneNumber(phoneNumber);
                modify(guest3);
                break;
            default:
                System.out.println("Optiune invalida!");
                break;
        }

    }

    private void modify(Guest guest) {
        if (guest != null) {
            System.out.println("Ce camp doriti sa modificati?  (1) Nume  (2) Prenume  (3) email  (4) Telefon");
            int x = sc.nextInt();
            sc.nextLine();
            System.out.print("Introduceti noile detalii pentru campul ales: ");
            String str = sc.nextLine();
            eveniment.modifyGuest(guest, x, str);
            System.out.println("Campul a fost schimbat cu succes");
        } else {
            System.out.println("Persoana nu a fost gasita");
        }
    }

    private void available() {
        System.out.println("Numarul de locuri disponibile la eveniment: " + this.eveniment.availableSeats());
    }

    private void guests_no() {
        System.out.println("Numarul de participanti inscrisi: " + this.eveniment.nrParticipanti());
    }

    private void waitlist_no() {
        System.out.println("Numarul de persoane pe lista de asteptare: " + this.eveniment.waitingListNumber());
    }

    private void subscribe_no() {
        System.out.println("Numarul total de persoane inscrise in ambele liste: " + this.eveniment.nrTotalPersoane());
    }


}
