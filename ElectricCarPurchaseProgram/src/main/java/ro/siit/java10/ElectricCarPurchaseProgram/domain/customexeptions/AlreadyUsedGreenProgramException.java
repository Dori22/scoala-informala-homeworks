package ro.siit.java10.ElectricCarPurchaseProgram.domain.customexeptions;

public class AlreadyUsedGreenProgramException extends Exception {

    public AlreadyUsedGreenProgramException(String message) {
        super(message);
    }
}
