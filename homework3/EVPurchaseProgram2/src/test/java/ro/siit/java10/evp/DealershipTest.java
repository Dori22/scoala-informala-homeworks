package ro.siit.java10.evp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DealershipTest {

    Dealership dealership = new Dealership("Marasti");

    @Test
    public void filterCarsByFastCharging() {
        // Arrange - ne aranjam datele
        ArrayList<DatabaseElement> filteredList = new ArrayList<DatabaseElement>();

        // Act-apelam metoda
        filteredList = dealership.filterCarsByFastCharging(dealership.getCarsList());

        // Assert-verificam corectitudinea datelor
        for (DatabaseElement element : filteredList) {
            assertTrue(element.getElectricCar().hasFastCharging());
        }
    }

    @Test
    public void filterCarsByStock() {
        ArrayList<DatabaseElement> filteredList= new ArrayList<DatabaseElement>();
        filteredList=dealership.filterCarsByStock(dealership.getCarsList());

        for (DatabaseElement element : filteredList) {
            assertTrue(element.getStock()>0);
        }



    }
}