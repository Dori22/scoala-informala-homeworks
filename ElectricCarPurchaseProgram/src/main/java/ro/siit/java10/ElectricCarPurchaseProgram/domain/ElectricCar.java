package ro.siit.java10.ElectricCarPurchaseProgram.domain;

public class ElectricCar {
    private String manufacturer;
    private String model;
    private int productionYear;
    private boolean fastCharging;
    private String electricMotor;
    private String electricBattery;
    private String consumption;
    private int horsePower;
    private int rangePerCharge;
    private boolean isNew;
    private int Id;

    public ElectricCar(String manufacturer, String model, int productionYear, boolean fastCharging, String electricMotor
            , String electricBattery, String consumption, int horsePower, int rangePerCharge, boolean isNew,int Id) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.fastCharging = fastCharging;
        this.electricMotor = electricMotor;
        this.electricBattery = electricBattery;
        this.consumption = consumption;
        this.horsePower = horsePower;
        this.rangePerCharge = rangePerCharge;
        this.isNew = isNew;
        this.Id=Id;
    }

    public ElectricCar() {
    }

    public String getManufacturer() {
        return manufacturer;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public boolean hasFastCharging() {
        return fastCharging;
    }

    public void setFastCharging(boolean fastCharging) {
        this.fastCharging = fastCharging;
    }

    public String getElectricMotor() {
        return electricMotor;
    }

    public void setElectricMotor(String electricMotor) {
        this.electricMotor = electricMotor;
    }

    public String getElectricBattery() {
        return electricBattery;
    }

    public void setElectricBattery(String electricBattery) {
        this.electricBattery = electricBattery;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getRangePerCharge() {
        return rangePerCharge;
    }

    public void setRangePerCharge(int rangePerCharge) {
        this.rangePerCharge = rangePerCharge;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public int getId() {
        return Id;
    }

    public ElectricCar setId(int id) {
        Id = id;
        return this;
    }

    @Override
    public String toString() {
        return "\nNumele masinii este: " + manufacturer + "\nModel: " + model + "\nIncarcare rapida: " + fastCharging +
                "\nRange-ul per masina:" + rangePerCharge + "\nPuterea masinii este: " + horsePower +
                "\nMasina este noua :" + isNew+"\nId=ul masinii este: "+Id;
    }
}

