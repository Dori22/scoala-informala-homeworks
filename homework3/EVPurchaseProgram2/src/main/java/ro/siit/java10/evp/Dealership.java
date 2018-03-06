package ro.siit.java10.evp;

public class Dealership {

    private DatabaseElement[] carsDatabase;
    private String name;

    public Dealership(String name) {
        carsDatabase = new DatabaseElement[100];
        this.name = name;
    }

    public DatabaseElement[] filterByFastCharging() {

        DatabaseElement[] filteredList = new DatabaseElement[carsDatabase.length];
        int i = 0;
        for (int j = 0; j < carsDatabase.length; j++) {
            if (carsDatabase[j].getElectricCar().hasFastCharging()) {
                filteredList[i] = carsDatabase[j];
                i++;
            }
        }
        return filteredList;

    }

    public DatabaseElement[] filterByStock() {

        DatabaseElement[] filteredList = new DatabaseElement[carsDatabase.length];

        int i = 0;
        for (int j = 0; j < carsDatabase.length; j++) {
            if (carsDatabase[j].getStock() > 0) {
                filteredList[i] = carsDatabase[j];
                i++;

            }
        }

        return filteredList;
    }}