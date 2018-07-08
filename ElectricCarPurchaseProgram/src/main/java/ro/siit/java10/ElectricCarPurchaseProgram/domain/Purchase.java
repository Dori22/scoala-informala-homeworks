package ro.siit.java10.ElectricCarPurchaseProgram.domain;

/**
 * This class shapes a transaction which is then stored in the Green Bonus Program
 * purchases history.
 */
public class Purchase {
    private String clientName;
    private String dealershipName;
    private String carModel;

    public Purchase(String clientName, String dealershipName, String carModel) {
        this.clientName = clientName;
        this.dealershipName = dealershipName;
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return clientName + " - " + dealershipName + " - " + carModel;
    }

    public String getClientName() {
        return clientName;
    }

    public String getDealershipName() {
        return dealershipName;
    }

    public String getCarModel() {
        return carModel;
    }
}
