package ro.siit.java10;

public class Dealership {

    private DatabaseElement[] carsDatabase;
    private String name;

    public Dealership(String name) {
        carsDatabase=new DatabaseElement[100];
        this.name = name;
    }
}
