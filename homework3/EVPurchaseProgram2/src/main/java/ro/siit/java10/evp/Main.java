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

        //      carDealership.printCarsList(carDealership.sortCarsByPrice(false));
//      carDealership.printCarsList(carDealership.sortCarsByRange(false));
        //   carDealership.printCarsList(carDealership.sortCarsByHorsePower(false));
//

//        carDealership.printCarsList((carDealership.sortCarsByRange(true)));
        //       carDealership.printCarsList((carDealership.sortCarsByRange(false)));
        //      carDealership.printCarsList(carDealership.sortCarsByHorsePower(true));
        //      carDealership.printCarsList(carDealership.sortCarsByHorsePower(false));

        try {
            DatabaseElement car = carDealership.getCarsList().get(9);
            Customer customer = new Customer("Petre", 30000);
            carDealership.buyCar(car, false, customer);
            System.out.println("Felicitari,sunteti fericitul posesor al masinii :" +
                    customer.getCar().getManufacturer() +" "+ customer.getCar().getModel());
            System.out.println("Stoc ramas  :" + car.getStock());
            System.out.println("Bugetul clientului dupa achizitie este  :" + customer.getBudget());
            System.out.println("Bugetul dealer-ului dupa vanzare este:  " + carDealership.getBudget());

        } catch (GreenBonusExeption | ElectricCarNotNewExeption | NotInStockException | NotEnoughFunds e) {
            System.err.println(e.getMessage());
        }

//           carDealership.printCarsList(carDealership.getCarsList());


    }
}
