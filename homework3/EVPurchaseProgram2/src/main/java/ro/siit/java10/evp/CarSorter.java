package ro.siit.java10.evp;

import java.util.Collections;
import java.util.List;

public class CarSorter {

    public static List<DatabaseElement> sortCarsByCriteria(List<DatabaseElement> initialCarList, int start, int end,
                                                           String criteria) {
        int pivotIndex;
        if (start < end) {
            pivotIndex = partition(initialCarList, start, end, criteria);
            sortCarsByCriteria(initialCarList, start, pivotIndex - 1, criteria);
            sortCarsByCriteria(initialCarList, pivotIndex + 1, end, criteria);
        }
        return initialCarList;
    }

    private static int partition(List<DatabaseElement> initialCarList, int start, int end, String criteria) {
        DatabaseElement pivot = initialCarList.get(end);
        int pivotIndex = start;  //aceata este pozitia unde ar trebui sa fie pivotul dupa ce a
        // fost facute toate swap-urile
        for (int i = start; i <= end - 1; i++) {
            //s-a mers pana la end -1 deoarece am luat end ca pivot
            //for-ul determina pe ce pozitie corecta(st mai mici, dr mai mari) ar trebui sa fie pivotul
            pivotIndex += swapElementsByCriteria(initialCarList, pivot, i, pivotIndex, criteria);
        }
        Collections.swap(initialCarList, pivotIndex, end);// se pune pivotul pe pozitia lui corecta
        return pivotIndex;
    }

    private static int swapElementsByCriteria(List<DatabaseElement> initialCarList, DatabaseElement pivot,
                                              int i, int pivotIndex, String criteria) {
        switch (criteria) {
            case "PriceAscending":
                if (initialCarList.get(i).getPrice() < pivot.getPrice()) {
                    Collections.swap(initialCarList, i, pivotIndex);
                    return 1;
                }
                break;
            case "PriceDescending":
                if (initialCarList.get(i).getPrice() > pivot.getPrice()) {
                    Collections.swap(initialCarList, i, pivotIndex);
                    return 1;
                }
                break;
            case "RangePerChargeAscending":
                if (initialCarList.get(i).getElectricCar().getRangePerCharge() <
                        pivot.getElectricCar().getRangePerCharge()) {
                    Collections.swap(initialCarList, i, pivotIndex);
                    return 1;
                }
                break;
            case "RangePerChargeDescending":
                if (initialCarList.get(i).getElectricCar().getRangePerCharge() >
                        pivot.getElectricCar().getRangePerCharge()) {
                    Collections.swap(initialCarList, i, pivotIndex);
                    return 1;
                }
                break;
            case "HorsePowerAscending":
                if (initialCarList.get(i).getElectricCar().getHorsePower() <
                        pivot.getElectricCar().getHorsePower()) {
                    Collections.swap(initialCarList, i, pivotIndex);
                    return 1;
                }
                break;
            case "HorsePowerDescending":
                if (initialCarList.get(i).getElectricCar().getHorsePower() >
                        pivot.getElectricCar().getHorsePower()) {
                    Collections.swap(initialCarList, i, pivotIndex);
                    return 1;
                }
                break;
        }
        return 0;// nu s-a facut swap  si nu incrementam pozitia indexului
    }
}


