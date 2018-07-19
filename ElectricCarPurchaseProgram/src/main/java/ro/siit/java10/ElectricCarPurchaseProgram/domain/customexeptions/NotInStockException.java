package ro.siit.java10.ElectricCarPurchaseProgram.domain.customexeptions;

public class NotInStockException extends Exception {
    public NotInStockException(String message) {
        super(message);
    }
}
