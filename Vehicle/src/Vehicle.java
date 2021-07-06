
public class Vehicle {
    private final String serialNumber;
    private int noPersons;
     String name;

    public Vehicle(String serialNumber, int noPersons) {
        this.serialNumber = serialNumber;
        this.noPersons = noPersons;
    }

    public Vehicle(String serialNumber, int noPersons,String name) {
        this(serialNumber, noPersons);
        this.name = name;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public boolean goTo(double positionX, double positionY) {
        System.out.println("Error: unknown vehicle cannot move…");
        return false;
    }

    public boolean addFuel(double amount){
        System.out.println("Error: unknown type of vehicle…");
        return false;
    }

    public void printInfo() {
        System.out.println("Vehicle properties:\n\t\t- serial number: " + this.getSerialNumber() + "\n\t\t" +
                "- capacity: " + this.noPersons + " persons\n\t\t- name: " + this.name);
    }

}