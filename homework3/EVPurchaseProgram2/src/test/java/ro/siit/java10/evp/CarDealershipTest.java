package ro.siit.java10.evp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CarDealershipTest {

    CarDealership carDealership = new CarDealership("Marasti");

    @Test
    public void filterCarsByFastCharging() {
        // Arrange - ne aranjam datele
        List<DatabaseElement> filteredList = new ArrayList<DatabaseElement>();

        // Act-apelam metoda
        filteredList = carDealership.filterCarsByFastCharging();

        // Assert-verificam corectitudinea datelor
        for (DatabaseElement element : filteredList) {
            assertTrue(element.getElectricCar().hasFastCharging());
        }
    }

    @Test
    public void filterCarsByStock() {
        List<DatabaseElement> filteredList = new ArrayList<DatabaseElement>();
        filteredList = carDealership.filterCarsByStock();

        for (DatabaseElement element : filteredList) {
            assertTrue(element.getStock() > 0);
        }
    }

    @Test
    public void sortCarsByPriceAscending() {
        List<DatabaseElement> sortedList = carDealership.sortCarsByPrice(true);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getPrice() <= sortedList.get(i + 1).getPrice());
        }
    }
    @Test
    public void sortCarsByPriceDescending() {
        List<DatabaseElement> sortedList = carDealership.sortCarsByPrice(false);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getPrice() >= sortedList.get(i + 1).getPrice());
        }
    }
    @Test
    public void sortCarsByHorsepowerAscending() {
        List<DatabaseElement> sortedList = carDealership.sortCarsByHorsePower(true);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getElectricCar().getHorsePower() <= sortedList.get(i + 1)
                    .getElectricCar().getHorsePower());
        }
    }
    @Test
    public void sortCarsByHorsepowerDescending() {
        List<DatabaseElement> sortedList = carDealership.sortCarsByHorsePower(false);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getElectricCar().getHorsePower() >= sortedList.get(i + 1)
                    .getElectricCar().getHorsePower());
        }
    }
    @Test
    public void sortCarsByRangeAscending() {
        List<DatabaseElement> sortedList = carDealership.sortCarsByRange(true);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getElectricCar().getRangePerCharge() <= sortedList.get(i + 1)
                    .getElectricCar().getRangePerCharge());
        }
    }
    @Test
    public void sortCarsByRangeDescending() {
        List<DatabaseElement> sortedList = carDealership.sortCarsByRange(false);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getElectricCar().getRangePerCharge()>= sortedList.get(i + 1)
                    .getElectricCar().getRangePerCharge());
        }
    }


}