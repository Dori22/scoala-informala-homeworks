package ro.siit.java10.evp;

public class DatabaseElement implements Comparable<DatabaseElement> {

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

    public int compareTo(DatabaseElement o) {
        // In general, contractul metodei compareTo() este urmatorul:
        // -daca un obiect este mai mic decat altul, metoda returneaza un numar negativ (conventie -1)
        // -daca un obiect este egal cu altul, metoda returneaza un 0
        // -daca un obiect este mai mare decat altul, metoda returneaza un numar pozitiv (conventie 1)

        // metoda compara un element cu elementul urmator.
        //in collections.sort se va face swap in funtie de rezultatele acestei metode

        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
}

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        }
    }
}
