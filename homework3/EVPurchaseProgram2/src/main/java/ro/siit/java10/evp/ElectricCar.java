package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.List;

public class ElectricCar {

    private String manufacturer;
    private int productionYear;
    private String model;
    private boolean fastCharging;
    private String electricMotor;
    private String electricBattery;
    private String consumption;
    private int horsePower;
    private int rangePerCharge;
    private boolean isNew;

    public ElectricCar(String manufacturer, int productionYear, String model, boolean fastCharging,
                       String electricMotor, String electricBattery, String consumption, int horsePower,
                       int rangePerCharge, boolean isNew) {
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.model = model;
        this.fastCharging = fastCharging;
        this.electricMotor = electricMotor;
        this.electricBattery = electricBattery;
        this.consumption = consumption;
        this.horsePower = horsePower;
        this.rangePerCharge = rangePerCharge;
        this.isNew = isNew;
    }

    public boolean hasFastCharging() {




        return fastCharging;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getRangePerCharge() {
        return rangePerCharge;
    }

    public boolean isNew() {
        return isNew;
    }
}