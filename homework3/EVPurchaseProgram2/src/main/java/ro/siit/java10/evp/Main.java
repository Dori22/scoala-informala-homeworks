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
            DatabaseElement car1 = carDealership.getCarsList().get(10);
            Customer customer1 = new Customer("Aurel Suciu", 24000);
            carDealership.buyCar(car1, true, customer1);
            carDealership.buyCar(car1, true, customer1);
            System.out.println("Felicitari,sunteti fericitul posesor al masinii :" +
                    customer1.getCar().getManufacturer() + " " + customer1.getCar().getModel());
            System.out.println("Stoc ramas  :" + car1.getStock());


            System.out.println("Bugetul clientului dupa achizitie este  :" + customer1.getBudget());
            System.out.println("Bugetul dealer-ului dupa vanzare este:  " + carDealership.getBudget());
            System.out.println("Bugetul Green Bonus dupa ultima tranzactie este:  " + GreenBonusProgram.getBudget());
            System.out.println("Mai jos gasiti tranzactiile efectuate cu Green Bonus");
            GreenBonusProgram.listPurchases();

        } catch (GreenBonusException | ElectricCarNotNewExeption | NotInStockException | NotEnoughFunds |
                AlreadyUsedGreenProgramException e) {
            System.err.println(e.getMessage());
        }

//           carDealership.printCarsList(carDealership.getCarsList());


    }
}
