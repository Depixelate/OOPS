package machines;
public abstract class Machine {
    protected String type;
    protected String fuelType;
    protected double energyConsumption;

    public Machine(String type, String fuelType, double energyConsumption) {
        this.type = type;
        this.fuelType = fuelType;
        this.energyConsumption = energyConsumption;
    }
    public String getType() {
        return type;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

}