package ro.siit.java10.evp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
            assertTrue(sortedList.get(i).getElectricCar().getRangePerCharge() >= sortedList.get(i + 1)
                    .getElectricCar().getRangePerCharge());
        }
    }

    @Test
    public void customerBuysCarAtFullPrice() throws AlreadyUsedGreenProgramException, NotInStockException,
            NotEnoughFunds, ElectricCarNotNewExeption, GreenBonusException {
        CarDealership carDealership = new CarDealership("Marasti");
        Customer customer = new Customer("Alin Dobre", 40000);
        DatabaseElement car = carDealership.getCarsList().get(11);

        carDealership.buyCar(car, false, customer);

        assertEquals(1000.00, customer.getBudget(), 0.01);
        assertEquals(39000.00, carDealership.getBudget(), 0.01);
        assertEquals(3, car.getStock());
    }

    @Test
    public void customerBuysNewCarUsingGreenBonusAndHasEntireAmount() throws AlreadyUsedGreenProgramException,
            NotInStockException, NotEnoughFunds, ElectricCarNotNewExeption, GreenBonusException {
        CarDealership carDealership = new CarDealership("Zorilor");
        Customer customer = new Customer("Alex Buzatu", 13000);
        DatabaseElement car = carDealership.getCarsList().get(8);

        carDealership.buyCar(car, true, customer);

        assertEquals(1000.00, customer.getBudget(), 0.01);
        assertEquals(22000.00, carDealership.getBudget(), 0.01);
        assertEquals(7, car.getStock());
    }

    @Test
    public void customerBuysNewCarUsingGreenBonusAndHasNotEnoughFunds() throws AlreadyUsedGreenProgramException,
            NotInStockException, ElectricCarNotNewExeption, GreenBonusException {
        CarDealership carDealership = new CarDealership("Zorilor");
        Customer customer = new Customer("Alex Buzatu", 11000);
        DatabaseElement car = carDealership.getCarsList().get(8);

        try {
            carDealership.buyCar(car, true, customer);
        } catch (NotEnoughFunds notEnoughFunds) {
            notEnoughFunds.printStackTrace();
        }

        assertEquals(11000.00, customer.getBudget(), 0.01);
        assertEquals(0.00, carDealership.getBudget(), 0.01);
        assertEquals(8, car.getStock());
    }

    @Test
    public void customerBuysNewCarUsingGreenBonusAndCarNotInStock() throws AlreadyUsedGreenProgramException,
            NotInStockException, ElectricCarNotNewExeption, GreenBonusException {
        CarDealership carDealership = new CarDealership("Zorilor");
        Customer customer = new Customer("Alex Buzatu", 25000);
        DatabaseElement car = carDealership.getCarsList().get(12);
        try {
            try {
                carDealership.buyCar(car, true, customer);
            } catch (NotInStockException e) {
                e.printStackTrace();
            }
        } catch (NotEnoughFunds notEnoughFunds) {
            notEnoughFunds.printStackTrace();
        }
        assertEquals(25000.00, customer.getBudget(), 0.01);
        assertEquals(0.00, carDealership.getBudget(), 0.01);
        assertEquals(0, car.getStock());
    }


    @Test
    public void customerBuysOldCarThatIsNotInStock() throws AlreadyUsedGreenProgramException,
            ElectricCarNotNewExeption, GreenBonusException, NotEnoughFunds {
        CarDealership carDealership = new CarDealership("Zorilor");
        Customer customer = new Customer("Alex Buzatu", 30000);
        DatabaseElement car = carDealership.getCarsList().get(6);

        try {
            carDealership.buyCar(car, false, customer);
        } catch (NotInStockException e) {
            e.printStackTrace();
        }
        assertEquals(30000.00, customer.getBudget(), 0.01);
        assertEquals(0.00, carDealership.getBudget(), 0.01);
        assertEquals(0, car.getStock());
    }

    @Test
    public void customerBuysCarUsingGreenBonusAndCarIsNotNew() throws AlreadyUsedGreenProgramException,
            NotInStockException, GreenBonusException, NotEnoughFunds {
        CarDealership carDealership = new CarDealership("Zorilor");
        Customer customer = new Customer("Alex Buzatu", 15000);
        DatabaseElement car = carDealership.getCarsList().get(1);
        try {
            carDealership.buyCar(car, true, customer);
        } catch (ElectricCarNotNewExeption electricCarNotNewExeption) {
            electricCarNotNewExeption.printStackTrace();
        }
        assertEquals(15000.00, customer.getBudget(), 0.01);
        assertEquals(0.00, carDealership.getBudget(), 0.01);
        assertEquals(5, car.getStock());
    }

    @Test
    public void customerBuysNewCarUsingGreenBonusAndNoMoreFundsAvailableFromGBProgram() throws
            NotEnoughFunds, NotInStockException, AlreadyUsedGreenProgramException, ElectricCarNotNewExeption {
        CarDealership carDealership = new CarDealership("Zorilor");
        Customer customer = new Customer("Alex Buzatu", 15000);
        DatabaseElement car = carDealership.getCarsList().get(0);
        GreenBonusProgram greenBonusProgram = new GreenBonusProgram();

        int totalFunds = 0;
        int carsSupported = GreenBonusProgram.getBudget() / GreenBonusProgram.FUNDS_PER_CAR;

        for (int i = 0; i < carsSupported; i++) {
            totalFunds += GreenBonusProgram.retrievedApprovedBudget(new Purchase("client" + i,
                    "dealer", "car"));
        }

        try {
            carDealership.buyCar(car, true, customer);
        } catch (GreenBonusException gbe) {
            System.err.println(gbe.getMessage());
        }

        assertEquals(15000.00, customer.getBudget(), 0.00);
        assertEquals(0.00, carDealership.getBudget(), 0.00);
        assertEquals(GreenBonusProgram.getBudget()-GreenBonusProgram.FUNDS_PER_CAR, greenBonusProgram.getBudget(), 0.00);//we need to change to 0
        // the budget in the GreenBonusProgram class
        assertEquals(4, car.getStock());
    }
    @Test
    public void customerBuysNewCarUsingGreenBonusAndHasAlreadyUsedTheGBProgram() throws GreenBonusException,
            NotInStockException, NotEnoughFunds, ElectricCarNotNewExeption {

                CarDealership carDealership = new CarDealership("Zorilor");
                Customer customer = new Customer("Alex Buzatu", 68000);
                DatabaseElement car = carDealership.getCarsList().get(10);
                GreenBonusProgram greenBonusProgram = new GreenBonusProgram();

                double initialBudget=GreenBonusProgram.getBudget();
                try {
                    carDealership.buyCar(car, true, customer);
                    carDealership.buyCar(car, true, customer);
                } catch (AlreadyUsedGreenProgramException e) {
                    System.out.println(e.getMessage());
                }


        assertEquals(44000.00, customer.getBudget(), 0.01);
                assertEquals(34000.00, carDealership.getBudget(), 0.01);
                assertEquals(initialBudget-GreenBonusProgram.FUNDS_PER_CAR,
                        greenBonusProgram.getBudget(), 0.01);
                assertEquals(8, car.getStock());

    }


}