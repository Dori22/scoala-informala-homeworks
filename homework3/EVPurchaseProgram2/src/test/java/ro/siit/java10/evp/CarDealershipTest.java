package ro.siit.java10.evp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarDealershipTest {

    CarDealership carDealership = new CarDealership("Marasti");

    @Test
    public void filterCarsByFastCharging() {
        // Arrange - ne aranjam datele
        ArrayList<DatabaseElement> filteredList = new ArrayList<DatabaseElement>();

        // Act-apelam metoda
        filteredList = carDealership.filterCarsByFastCharging();

        // Assert-verificam corectitudinea datelor
        for (DatabaseElement element : filteredList) {
            assertTrue(element.getElectricCar().hasFastCharging());
        }
    }

    @Test
    public void filterCarsByStock() {
        ArrayList<DatabaseElement> filteredList= new ArrayList<DatabaseElement>();
        filteredList= carDealership.filterCarsByStock();

        for (DatabaseElement element : filteredList) {
            assertTrue(element.getStock()>0);
        }



    }
}