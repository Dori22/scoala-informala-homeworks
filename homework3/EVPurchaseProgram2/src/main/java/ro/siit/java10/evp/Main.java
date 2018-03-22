package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Dealership dealership = new Dealership("Marasti");
//        dealership.printCarsList(dealership.getCarsList());

        // consuma prea multa memorie
//        ArrayList<DatabaseElement> list = dealership.filterCarsByFastCharging(dealership.getCarsList());
//        dealership.printCarsList(list);

//        dealership.printCarsList(dealership.filterCarsByFastCharging(dealership.getCarsList()));


//        dealership.filterCarsByStock(dealership.getCarsList());
        dealership.printCarsList((dealership.filterCarsByStock(dealership.getCarsList())));
    }
}
