package ro.siit.java10.ElectricCarPurchaseProgram.domain;

public class DatabaseElement {
    private ElectricCar electricCar;
    private int stock;
    private double price;

    public DatabaseElement(ElectricCar electricCar, int stock, double price) {
        this.electricCar = electricCar;
        this.stock = stock;
        this.price = price;
    }

    public DatabaseElement() {
    }

    public ElectricCar getElectricCar() {
        return electricCar;
    }

    public void setElectricCar(ElectricCar electricCar) {
        this.electricCar = electricCar;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        }
    }

    @Override
    public String toString() {
        return electricCar.toString() + "\nStoc: " + stock + "\nPretul este: " + price;
    }
}
