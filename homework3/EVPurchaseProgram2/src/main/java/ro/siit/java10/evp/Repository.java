package ro.siit.java10.evp;

import java.util.ArrayList;

public class Repository {

    private ArrayList<DatabaseElement> carsList;


    public Repository() {

        carsList = new ArrayList<DatabaseElement>();

        initializeCarsList();
    }

    public ArrayList<DatabaseElement> getCarsList() {
        return carsList;
    }

    private void initializeCarsList() {



        carsList.add(new DatabaseElement(new ElectricCar("Honda", 2016, "SRV",
                false, "yes", "yes", "100KW", 250,
                250, false),4,25000.00));
        carsList.add(new DatabaseElement(new ElectricCar("Volkswagen", 2017, "e-UP ",
                false, "yes", "yes", "150KW", 115,
                300, false),5,25000));
        carsList.add(new DatabaseElement(new ElectricCar("Volkswagen", 2018, "e-Golf ",
                true, "yes", "yes", "200KW", 225,
                200, true),2,38000));
        carsList.add(new DatabaseElement(new ElectricCar("Renault", 2018, "Zoe ",
                true, "yes", "yes", "170KW", 110,
                200, true),3,33000));
        carsList.add(new DatabaseElement(new ElectricCar("Renault", 2016, "E-Megan",
                false, "yes", "yes", "100KW", 95,
                350, false),0,21000));
        carsList.add(new DatabaseElement(new ElectricCar("BMW", 2018, "i3",
                true, "yes", "yes", "250KW", 275,
                365, true),0,40000));
        carsList.add(new DatabaseElement(new ElectricCar("BMW", 2017, "5 series",
                false, "yes", "yes", "275KW", 280,
                320, false),0,30000));
        carsList.add(new DatabaseElement(new ElectricCar("Smart", 2018, "FourTwo Cabrio ",
                true, "yes", "yes", "100KW", 85,
                400, true),9,23000));
        carsList.add(new DatabaseElement(new ElectricCar("Smart", 2018, "FourTwo",
                true, "yes", "yes", "160KW", 125,
                290, true),8,22000));
        carsList.add(new DatabaseElement(new ElectricCar("Smart", 2017, "FourFour ",
                false, "yes", "yes", "150KW", 115,
                250, false),1,22700));
        carsList.add(new DatabaseElement(new ElectricCar("Kia", 2018, "Soul",
                true, "yes", "yes", "450KW", 450,
                250, true),9,34000));
        carsList.add(new DatabaseElement(new ElectricCar("Hyundai", 2018, "Ioniq ",
                true, "yes", "yes", "350KW", 400,
                150, true),4,0));
        carsList.add(new DatabaseElement(new ElectricCar("Hyundai", 2017, "E-Sonata",
                false, "yes", "yes", "150KW", 115,
                300, false),0,45000));
    }
}
