package ro.siit.java10.ElectricCarPurchaseProgram.domain;

public class Customer {
    private String name;
    private double budget;
    private ElectricCar car;
    private int cnp;

    public Customer(String name, double budget) {
        this.name = name;
        this.budget = budget;


    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ElectricCar getCar() {
        return car;
    }

    public void setCar(ElectricCar car) {
        this.car = car;
    }
}


