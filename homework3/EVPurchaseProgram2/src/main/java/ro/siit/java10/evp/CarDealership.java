package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarDealership {


    private String name;
    private Repository repository;
    private double budget;

    public CarDealership(String name) {
        this.name = name;
        repository = new Repository();
        budget = 0;
    }

    public ArrayList<DatabaseElement> getCarsList() {
        return repository.getCarsList();
    }

    public ArrayList<DatabaseElement> filterCarsByFastCharging() {

        return CarFilter.filterCarsByFastCharging(repository.getCarsList());
    }

    public ArrayList<DatabaseElement> filterCarsByStock() {

        return CarFilter.filterCarsByStock(repository.getCarsList());
    }


    public void printCarsList(ArrayList<DatabaseElement> listToBePrinted) {
        System.out.println("Lista de masini primita de metoda este:\n");

        for (DatabaseElement element : listToBePrinted) {
            System.out.println("\nNumele masinii este: " + element.getElectricCar().getManufacturer());
            System.out.println("\nModel: " + element.getElectricCar().getModel());
            System.out.println("\nStoc: " + element.getStock());
            System.out.println("\nPretul este: " + element.getPrice());
            System.out.println("\nIncarcare rapida: " + element.getElectricCar().hasFastCharging());
            System.out.println("\nRange-ul per masina: " + element.getElectricCar().getRangePerCharge());
            System.out.println("\nPuterea masinii este:" + element.getElectricCar().getHorsePower());
            System.out.println("\nMasina este noua :  " + element.getElectricCar().isNew());

        }

    }

    public ArrayList<DatabaseElement> sortCarsByPrice(boolean inAscendingOrder) {

        return CarSorter.sortCarsByPrice(repository.getCarsList(), inAscendingOrder);
    }

    public ArrayList<DatabaseElement> sortCarsByRange(boolean inAscendingOrder) {
        return CarSorter.sortCarsByRange(repository.getCarsList(), inAscendingOrder);
    }

    public ArrayList<DatabaseElement> sortCarsByHorcePower(boolean inAscendingOrder) {
        return CarSorter.sortCarsByHorcePower(repository.getCarsList(), inAscendingOrder);
    }


    public void buyCar(DatabaseElement wantedVehicle, boolean withGreenBonus) throws NotInStockException,
            GreenBonusExeption, ElectricCarNotNewExeption, NotEnoughFunds {

        if (wantedVehicle.getStock() == 0) {
            throw new NotInStockException(" This vehicle is not currently in stock");
        } else {
            if (withGreenBonus) {
                if (GreenBonusProgram.availability()) {

                    if (wantedVehicle.getElectricCar().isNew()) {
                        // daca masina este available si este noua
                        String[] clientData = getClientData();
                        completeTransaction(wantedVehicle, clientData[0], Double.parseDouble(clientData[1]), true);

                    } else {
                        throw new ElectricCarNotNewExeption("Green bonus program can be used only for new EV vehicles");
                    }
                } else {
                    throw new GreenBonusExeption(" Insufficient Green Bonus Funds");
                }
            } else {
                // clientul nu doreste sa achizitioneze masina cu GB
                String[] clientData = getClientData();
                completeTransaction(wantedVehicle, clientData[0], Double.parseDouble(clientData[1]), false);
            }
        }



    }


    private String[] getClientData() {
        // TODO: 4/3/2018 gets client data from file/input window/console etc.
        return null;
    }

    private void completeTransaction(DatabaseElement car, String clientName, double clientBudget, boolean withGreenBonus) throws NotEnoughFunds {
        if (withGreenBonus) {
            if (car.getPrice() > clientBudget + 10000) {
                throw new NotEnoughFunds("You have insufficient funds to purchase this vehicle");
            } else {
                // cumparam masina  folosind programul de Green Bonus
                budget += car.getPrice();
                // decreaseClientBudget();
                // TODO: 4/3/2018  trebuie implementata metoda decreaseClientBudget()
                budget += GreenBonusProgram.approvedBudget(new Purchase(clientName, name, car.getElectricCar().getModel()));
                car.decreaseStock();

                // sendCarToCustomer();
                // TODO: 4/3/2018 implementare metoda sendCarToCustomer sau ceva mesaj de preluare a masinii din car dealership

            }
        } else {
            //sell car with full price
            if (car.getPrice() > clientBudget) {

                throw new NotEnoughFunds("You have insufficient funds to purchase this vehicle");
            } else {
                //cumperi masina la full price

            }

        }

    }

}
