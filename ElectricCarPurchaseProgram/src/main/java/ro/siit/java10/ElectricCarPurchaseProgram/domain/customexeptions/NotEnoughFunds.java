package ro.siit.java10.ElectricCarPurchaseProgram.domain.customexeptions;

public class NotEnoughFunds extends Exception {
    public NotEnoughFunds(String message) {
        super(message);
    }
}
