package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarSorter {

    public static ArrayList<DatabaseElement> sortCarsByPrice(ArrayList<DatabaseElement> initialCarList,
                                                             boolean inAscendingOrder) {

        Comparator<DatabaseElement> priceComparator;
        // daca sortarea se face in ordine crescatoare

        if (inAscendingOrder == true) {
            // clasa anonima care presupune implementarea pe loc a unei metode
            priceComparator = new Comparator<DatabaseElement>() {
                public int compare(DatabaseElement o1, DatabaseElement o2) {
                    if (o1.getPrice() < o2.getPrice()) {
                        return -1;
                    } else if (o1.getPrice() > o2.getPrice()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            };
        } else {
            priceComparator = new Comparator<DatabaseElement>() {
                public int compare(DatabaseElement o1, DatabaseElement o2) {
                    if (o1.getPrice() < o2.getPrice()) {
                        return 1;
                    } else if (o1.getPrice() > o2.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            };
        }

        ArrayList<DatabaseElement> sortedCarsListByPrice = new ArrayList<DatabaseElement>();

        // copiem lista initiala intr-o alta lista separata pentru a putea sorta dupa pret

        sortedCarsListByPrice.addAll(initialCarList);
//
        // sorteaza lista noastra clonata.daca se foloseste doar un argument(sortedCarsListByPrice)
        // atunci se face sortarea folosinduse metoda compareTo.Daca se folosesc doua argumente (ca si mai jos0
        //trebuie sa avem un comparator definit vezi metoda sortCarsByPrice de mai sus)
        Collections.sort(sortedCarsListByPrice, priceComparator);

        return sortedCarsListByPrice;
    }


    public static ArrayList<DatabaseElement> sortCarsByRange(ArrayList<DatabaseElement> initialCarList,
                                                             boolean inAscendingOrder) {
        Comparator<DatabaseElement> rangeComparator;

        if (inAscendingOrder == true) {

            rangeComparator = new Comparator<DatabaseElement>() {
                public int compare(DatabaseElement o1, DatabaseElement o2) {
                    if (o1.getElectricCar().getHorsePower() < o2.getElectricCar().getHorsePower()) {
                        return -1;
                    } else if (o1.getElectricCar().getHorsePower() > o2.getElectricCar().getHorsePower()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }

            };
        } else {
            rangeComparator = new Comparator<DatabaseElement>() {
                public int compare(DatabaseElement o1, DatabaseElement o2) {
                    if (o1.getElectricCar().getHorsePower() < o2.getElectricCar().getHorsePower()) {
                        return 1;
                    } else if (o1.getElectricCar().getHorsePower() > o2.getElectricCar().getHorsePower()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

            };

        }
        ArrayList<DatabaseElement> sortedCarsListByRange = new ArrayList<DatabaseElement>();
        sortedCarsListByRange.addAll(initialCarList);
        Collections.sort(sortedCarsListByRange, rangeComparator);

        return sortedCarsListByRange;
    }

    public static ArrayList<DatabaseElement> sortCarsByHorcePower(ArrayList<DatabaseElement> initialCarList,
                                                                  boolean inAscendingOrder) {
        Comparator<DatabaseElement> horsePowerComparator;

        if (inAscendingOrder == true) {

            horsePowerComparator = new Comparator<DatabaseElement>() {
                public int compare(DatabaseElement o1, DatabaseElement o2) {
                    if (o1.getElectricCar().getHorsePower() < o2.getElectricCar().getHorsePower()) {
                        return -1;
                    } else if (o1.getElectricCar().getHorsePower() > o2.getElectricCar().getHorsePower()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }

            };
        } else {
            horsePowerComparator = new Comparator<DatabaseElement>() {
                public int compare(DatabaseElement o1, DatabaseElement o2) {
                    if (o1.getElectricCar().getHorsePower() < o2.getElectricCar().getHorsePower()) {
                        return 1;
                    } else if (o1.getElectricCar().getHorsePower() > o2.getElectricCar().getHorsePower()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

            };

        }
        ArrayList<DatabaseElement> sortCarsByHorcePower = new ArrayList<DatabaseElement>();
        sortCarsByHorcePower.addAll(initialCarList);
        Collections.sort(sortCarsByHorcePower, horsePowerComparator);

        return sortCarsByHorcePower;

    }
}


