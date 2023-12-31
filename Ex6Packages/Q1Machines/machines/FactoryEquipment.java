package machines;

public class FactoryEquipment extends Machine {
    public FactoryEquipment(String type, double energyConsumption) {
        super(type, "electricity", energyConsumption);
    }

    public String toString() {
        return String.format("FACTORY EQUIPMENT: type=%s, fuel type=%s, energy consumption = %f kJ/hr", type, fuelType, energyConsumption);
    }
}
