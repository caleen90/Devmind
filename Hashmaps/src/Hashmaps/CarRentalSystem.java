package Hashmaps;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class CarRentalSystem implements Serializable {
    private static Scanner sc = new Scanner(System.in);
    private HashMap<String, String> rentedCars = new HashMap<String, String>(100, 0.5f);
    private Hashtable<String, RentedCars> ownedCars = new Hashtable<>(100,0.5f);
    private static final long serialVersionUID = 1L;


    private static String getPlateNo() {
        System.out.println("Introduceti numarul de inmatriculare:");
        return sc.nextLine();
    }

    private static String getOwnerName() {
        System.out.println("Introduceti numele proprietarului:");
        return sc.nextLine();
    }

    // search for a key in hashtable
    private boolean isCarRent(String plateNo) {
        return rentedCars.containsKey(plateNo);
    }

    private boolean isPersonRenting(String ownerName){
        return ownedCars.containsKey(ownerName);
    }

    // get the value associated to a key
    private String getCarRent(String plateNo) throws Errors.NotFound{
        String nume = rentedCars.get(plateNo);
       if(nume == null) {
           throw new Errors.NotFound();                                                   //error
       }else{
           return "Masina este inchiriata de " + nume;  //1.3
       }
    }

    // add a new (key, value) pair
    private void rentCar(String plateNo, String ownerName) {
        if(isCarRent(plateNo)){
            System.out.println("masina este deja inchiriata"); // 1.1
        } else {
            rentedCars.put(plateNo, ownerName);
            if(ownedCars.containsKey(ownerName)){
                try {
                    ownedCars.get(ownerName).addPlate(plateNo);
                } catch (Errors.AlreadyRented e){
                    System.out.println("masina este deja inchiriata");
                }
            } else {
                ownedCars.put(ownerName,new RentedCars());
                ownedCars.get(ownerName).addPlate(plateNo);
            }
        }
    }

    // remove an existing (key, value) pair
    private void returnCar(String plateNo) throws Errors.NotFound {
        if(ownedCars.containsKey(rentedCars.get(plateNo))){
            ownedCars.get(rentedCars.get(plateNo)).removePlate(plateNo);
        }
        if(rentedCars.remove(plateNo) != null){
            System.out.println("Masina a fost returnata"); // 1.2
        } else {
            throw new Errors.NotFound();                                                  //error
        }
    }

    private int getSize(){               // 1.4
       return rentedCars.size();
    }

    public int getCarsNo(String ownersName) throws Errors.NotFound {
        if(ownedCars.containsKey(ownersName)) {
            return ownedCars.get(ownersName).getCarsNo();
        } else {
            throw new Errors.NotFound();                                                     //error
        }
    }

    public String getCarsList(String ownersName) throws Errors.NotFound{
        if(ownedCars.containsKey(ownersName)) {
            return ownedCars.get(ownersName).getCarList();
        } else {
            throw new Errors.NotFound();                                                 //error
        }

    }

    private static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("quit         - Inchide aplicatia");
        System.out.println("totalRented    Afiseaza numarul de masini inchiriate");
        System.out.println("nrMasini      -Afiseaza numarul de masini inchiriate de o anumita persoana");
        System.out.println("listaMasini   -Afiseaza lista cu masinile inchiriate de o persoana");
    }

    public void run() throws IOException {
        try(ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("save.dat")))){
            this.rentedCars = (HashMap<String, String>) input.readObject();
            this.ownedCars = (Hashtable<String, RentedCars>) input.readObject();
        } catch (ClassNotFoundException e){
            System.out.println("class not found " + e.getMessage());
        } catch (EOFException e){
            System.out.println("EOF" + e.getMessage());
        }
        boolean quit = false;
        while(!quit) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                String command = sc.nextLine();
            switch(command) {
                case "help":
                    printCommandsList();
                    break;
                case "add":
                    rentCar(getPlateNo(), getOwnerName());
                    break;
                case "check":
                    System.out.println(isCarRent(getPlateNo()));
                    break;
                case "remove":
                    try {
                        returnCar(getPlateNo());
                    } catch (Errors.NotFound e){
                        System.out.println("Masina nu este trecuta in sistem");
                    } finally {
                        break;
                    }
                case "getOwner":
                    try {
                        System.out.println(getCarRent(getPlateNo()));
                    } catch(Errors.NotFound e){
                        System.out.println("Nu exista persoana asociata cu acest numar");
                    } finally {
                        break;
                    }
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    try(ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("save.dat")))){
                        output.writeObject(this.rentedCars);
                        output.writeObject(this.ownedCars);
                    }
                    quit = true;
                    break;
                case "totalRented":
                    System.out.println("Masini inchiriate: " + getSize());
                    break;
                case "nrMasini":
                    try {
                        System.out.println(getCarsNo(getOwnerName()));
                    }catch(Errors.NotFound e) {
                        System.out.println("numele nu are masini inregistrate");
                    } finally {
                        break;
                    }
                case "listaMasini":
                    try {
                        System.out.println(getCarsList(getOwnerName()));
                    } catch (Errors.NotFound e) {
                        System.out.println("Nu sunt inregistrate masini pe acest nume");
                    } finally {
                        break;
                    }
                default:
                    System.out.println("Unknown command. Choose from:");
                    printCommandsList();
            }
        }
    }

    public static void main(String[] args) throws IOException{

        // create and run an instance (for test purpose)
        new CarRentalSystem().run();
    }
}
