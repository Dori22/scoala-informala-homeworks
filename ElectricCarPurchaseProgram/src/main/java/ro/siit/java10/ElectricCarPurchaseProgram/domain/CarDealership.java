package ro.siit.java10.ElectricCarPurchaseProgram.domain;

import ro.siit.java10.ElectricCarPurchaseProgram.domain.customexeptions.*;

import java.util.List;

public class CarDealership {
    private String name;
    private double budget;

    public CarDealership(String name) {
        this.name = name;
        budget = 0;
    }

    public void printCarsList(List<DatabaseElement> listToBePrinted) {
        System.out.println("Lista de masini primita de metoda este:\n");
        for (DatabaseElement element : listToBePrinted) {
            System.out.print("*******************************************");
            System.out.println(element);
        }
    }

    public void buyCar(DatabaseElement wantedVehicle, boolean withGreenBonus, Customer customer) throws NotInStockException,
            GreenBonusException, ElectricCarNotNewExeption, NotEnoughFunds, AlreadyUsedGreenProgramException {
        if (wantedVehicle.getStock() == 0) {
            throw new NotInStockException(" This vehicle is not currently in stock");
        } else if (withGreenBonus) {
            if (GreenBonusProgram.areFundsAvailable(customer.getName())) {
                if (wantedVehicle.getElectricCar().isNew()) {
                    // daca masina este available si este noua

                    completeTransaction(wantedVehicle, customer, true);
                } else {
                    throw new ElectricCarNotNewExeption("Green bonus program can be used only for new Electric vehicles");
                }
            } else {
                throw new GreenBonusException(" Insufficient Green Bonus Funds");
            }
        } else {
            // clientul nu doreste sa achizitioneze masina cu greenBonus
            completeTransaction(wantedVehicle, customer, false);
        }
    }

    private void completeTransaction(DatabaseElement car, Customer customer,
                                     boolean withGreenBonus) throws NotEnoughFunds {
        if (withGreenBonus) {
            if (car.getPrice() > customer.getBudget() + GreenBonusProgram.FUNDS_PER_CAR) {
                throw new NotEnoughFunds("You have insufficient funds to purchase this vehicle");
            } else {
                // cumparam masina  folosind programul de Green Bonus
                budget += car.getPrice() - GreenBonusProgram.FUNDS_PER_CAR;//bugetul dealer-ului este egal cu
                //pretul masini -green bonus (10K);
                ///deealership ia bani de la green bonus si trimite inapoi// catre GB program date despre tranzactie
                budget += GreenBonusProgram.retrievedApprovedBudget(new Purchase(customer.getName(), name,
                        car.getElectricCar().getManufacturer() + " " + car.getElectricCar().getModel()));
                car.decreaseStock();

                customer.setBudget(customer.getBudget() - car.getPrice() + GreenBonusProgram.FUNDS_PER_CAR);
                customer.setCar(car.getElectricCar());
            }
        } else {
            //sell car with full price
            if (car.getPrice() > customer.getBudget()) {

                throw new NotEnoughFunds("You have insufficient funds to purchase this vehicle");
            } else {
                //cumperi masina la full price
                this.budget += car.getPrice();
                car.decreaseStock();
                customer.setBudget(customer.getBudget() - car.getPrice());
                customer.setCar(car.getElectricCar());
            }
        }
    }

    public double getBudget() {
        return budget;
    }

    public String checkIfGBAvailableForThisCar(DatabaseElement carToTestGB) throws NotInStockException,
            ElectricCarNotNewExeption, GreenBonusException {
        if (carToTestGB.getStock() == 0) {
            throw new NotInStockException(" This vehicle is not currently in stock");
        }

        if (carToTestGB.getElectricCar().isNew() == false) {
            throw new ElectricCarNotNewExeption("Green bonus program can be used only for new Electric vehicles");
        }
        if (GreenBonusProgram.getBudget() == 0) {
            throw new GreenBonusException(" Insufficient Green Bonus Funds");

        }

        return "Green Bonus is Available";
    }
}



