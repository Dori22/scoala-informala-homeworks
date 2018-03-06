package ro.siit.java10.evp;

public class Customer {
    private String name;
    private double budget;

    public Customer(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public void filterByFastCharging( Dealership dealership ){

        DatabaseElement[] filteredList = dealership.filterByFastCharging();

        for (int i=0; i<filteredList.length;i++) {
            System.out.println();
        }
    }
}


