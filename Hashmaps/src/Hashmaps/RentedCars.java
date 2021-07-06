package Hashmaps;

import java.io.Serializable;
import java.util.ArrayList;

public class RentedCars implements Serializable {
    private int carsNo;
    private ArrayList<String> cars;
    private static final long serialVersionUID = 1L;

    public RentedCars(){
        carsNo = 0;
        cars = new ArrayList<>();
    }

    public void addPlate(String plateNo) throws Errors.AlreadyRented {
        if(cars.contains(plateNo)){
            throw new Errors.AlreadyRented();
        } else {
            cars.add(plateNo);
            carsNo++;
        }
    }

    public void removePlate(String plateNo){
        if(cars.contains(plateNo)){
            cars.remove(plateNo);
            carsNo--;
        } else{
            System.out.println("masina nu este inchiriata de aceasta persoana");
        }
    }

    public int getCarsNo(){
        return carsNo;
    }

    public String getCarList(){
        String carList = "";
        for(String i : cars){
            carList += i + "\n";
        }
        return carList;
    }
}
