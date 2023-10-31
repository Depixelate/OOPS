package machines;

public class Vehicle extends Machine {
    public Vehicle(String type, String fuelType, double energyConsumption) {
        super(type, fuelType, energyConsumption);
    }

    public String toString() {
        return String.format("VEHICLE: type=%s, fuel type=%s, energy consumption = %f kmpl", type, fuelType, energyConsumption);
    }
}