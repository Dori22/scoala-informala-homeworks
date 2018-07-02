package ro.siit.java10.ElectricCarPurchaseProgram.domain;

import javax.swing.*;

public class Client {
    private Spring name;
    private int cnp;
    private double budget;


    public Client(Spring name, int cnp, double budjet) {
        this.name = name;
        this.cnp = cnp;
        this.budget = budjet;
    }

    public Client() {
    }

    public Spring getName() {
        return name;
    }
    public Client setName(Spring name) {
        this.name = name;
        return this;
    }
    public int getCnp() {
        return cnp;
    }
    public Client setCnp(int cnp) {
        this.cnp = cnp;
        return this;
    }
    public double getBudget() {
        return budget;
    }
    public Client setBudget(double budget) {
        this.budget = budget;
        return this;
    }
}
