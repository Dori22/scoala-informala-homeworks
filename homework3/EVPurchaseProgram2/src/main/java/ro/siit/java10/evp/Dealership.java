package ro.siit.java10.evp;

import java.util.ArrayList;

public class Dealership {


    private String name;
    private Repository repository;

    public Dealership(String name) {
        this.name = name;
        repository = new Repository();
    }

    public ArrayList<DatabaseElement> getCarsList() {
        return repository.getCarsList();
    }

    public ArrayList<DatabaseElement> filterCarsByFastCharging(ArrayList<DatabaseElement> initialCarsList) {

        // filteredCarList este o variabila de tip ArrayList care contine elemente de tip DatabaseElement
        ArrayList<DatabaseElement> filteredCarList = new ArrayList<DatabaseElement>();

//        // se parcurge cu ajutorul indexului i de la 0 la lenght-1
//        for (int i = 0; i < initialCarsList.size(); i++) {
//
//            //initialCarsList.get(i)-returneaza DatabaseElement de pe pozitia i din lista initiala
//            //initialCarsList.get(i).getElectricCar()- returneaza din DatabaseElement (frigider) campul ElectricCar (sertarul)
//            // initialCarsList.get(i).getElectricCar().hasFastCharging()-returneaza din ElectricCar valoarea(mancarea) de FastCharging
//
//            if (initialCarsList.get(i).getElectricCar().hasFastCharging() == true) {
//
//                // daca masina are FastCharging se adauga in lista noua(filteredCarList)
//                filteredCarList.add(initialCarsList.get(i));
//            }
//
//        }
//
//        return filteredCarList;


        // declari o variabila la nivel de for de tipul elementelor din lista(element) care va parcurge lista si ia
        // continutul fiecarui element din lista

        for (DatabaseElement element : initialCarsList) {

            // daca masina are FastCharging se adauga in lista noua(filteredCarList)

            if (element.getElectricCar().hasFastCharging() == true) {
                filteredCarList.add(element);
            }
        }

        return filteredCarList;
    }

    public ArrayList<DatabaseElement> filterCarsByStock(ArrayList<DatabaseElement> initialCarList) {

        ArrayList<DatabaseElement> filteredCarList = new ArrayList<DatabaseElement>();

        for (DatabaseElement element : initialCarList) {
            if (element.getStock() > 0) {

                filteredCarList.add(element);
            }
        }

        return filteredCarList;

    }

    public void printCarsList(ArrayList<DatabaseElement> listToBePrinted) {
        System.out.println("Lista de masini primita de metoda este:\n");

        for (DatabaseElement element : listToBePrinted) {
            System.out.println("\nNumele masinii este: " + element.getElectricCar().getManufacturer());
            System.out.println("Model: " + element.getElectricCar().getModel());
            System.out.println("Stoc: " + element.getStock());
            System.out.println("Pretul este: " + element.getPrice());
            System.out.println("Incarcare rapida: " + element.getElectricCar().hasFastCharging());
        }

    }


}