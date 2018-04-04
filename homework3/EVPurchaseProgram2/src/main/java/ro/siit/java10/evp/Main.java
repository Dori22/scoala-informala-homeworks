package ro.siit.java10.evp;

public class Main {

    public static void main(String[] args) {

        CarDealership carDealership = new CarDealership("Marasti");
//        carDealership.printCarsList(carDealership.getCarsList());

        // consuma prea multa memorie
//        ArrayList<DatabaseElement> list = carDealership.filterCarsByFastCharging();
//        carDealership.printCarsList(list);

//        carDealership.printCarsList(carDealership.filterCarsByFastCharging());

//        carDealership.printCarsList(carDealership.filterCarsByStock());

//        carDealership.printCarsList(carDealership.sortCarsByPrice(carDealership.getCarsList(), true));
//        carDealership.printCarsList(carDealership.sortCarsByPrice(false));

//        carDealership.printCarsList((carDealership.sortCarsByRange(true)));
        //       carDealership.printCarsList((carDealership.sortCarsByRange(false)));
        //      carDealership.printCarsList(carDealership.sortCarsByHorcePower(true));
        //      carDealership.printCarsList(carDealership.sortCarsByHorcePower(false));

        try {
            DatabaseElement car = carDealership.getCarsList().get(9);
            carDealership.buyCar(car, true);

        } catch (GreenBonusExeption e) {
            System.err.println(e.getMessage());
        } catch (NotEnoughFunds e) {
            System.err.println(e.getMessage());
        } catch (NotInStockException e) {
            System.err.println(e.getMessage());
        } catch (ElectricCarNotNewExeption e) {
            System.err.println(e.getMessage());
        }


    }
}
