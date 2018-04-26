package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.List;

public class CarFilter {

    public static List<DatabaseElement> filterCarsByFastCharging(List<DatabaseElement> initialCarsList) {
        List<DatabaseElement> filteredCarList = new ArrayList<DatabaseElement>();
        for (DatabaseElement element : initialCarsList) {
            if (element.getElectricCar().hasFastCharging() == true) {
                filteredCarList.add(element);
            }
        }
        return filteredCarList;
    }

    public static List<DatabaseElement> filterCarsByStock(List<DatabaseElement> initialCarList) {
        List<DatabaseElement> filteredCarList = new ArrayList<DatabaseElement>();
        for (DatabaseElement element : initialCarList) {
            if (element.getStock() > 0) {
                filteredCarList.add(element);
            }
        }
        return filteredCarList;
    }
}
