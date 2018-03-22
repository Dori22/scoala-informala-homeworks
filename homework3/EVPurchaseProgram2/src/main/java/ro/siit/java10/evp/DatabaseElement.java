package ro.siit.java10.evp;

public class DatabaseElement {

    private ElectricCar electricCar;
    private int stock;
    private double price;

    public DatabaseElement(ElectricCar electricCar, int stock, double price) {
        this.electricCar = electricCar;
        this.stock = stock;
        this.price = price;
    }

    public ElectricCar getElectricCar() {
        return electricCar;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }
}
