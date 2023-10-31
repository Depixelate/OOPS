import java.util.Scanner;

import machines.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void printf(String fmt, Object... args) {
        System.out.printf(fmt, args);
    }
    public static void printfn(String fmt, Object... args) {
        printf(fmt + "\n", args);
    }

    public static String readType() {
        printf("What should the type be: ");
        return sc.nextLine();
    }

    public static String readFuelType() {
        printf("What should the fuel type be: ");
        return sc.nextLine();
    }

    public static double readEnergyConsumption() {
        printf("What is the energy consumption amount: ");
        return Double.parseDouble(sc.nextLine());
    }

    public static void main(String[] args) {
        printfn("1. Create Home Appliance");
        printfn("2. Create Factory Equipment");
        printfn("3. Create Vehicle");
        printf("What do you want to do: ");
        int option = Integer.parseInt(sc.nextLine());
        Machine m;
        String type = readType();
        double consumption = readEnergyConsumption();
        switch (option) {
            case 1:
                m = new HomeAppliance(type, consumption);
                break;
            case 2:
                m = new FactoryEquipment(type, consumption);
                break;
            default:
                String fuelType = readFuelType();
                m = new Vehicle(type, fuelType, consumption);
                break;
        }
        printfn("%s",m);


        // Machine hondaVenue = new Vehicle("car", "petrol", 17.5);
        // var fridgeKilojoulesPerHour = 475.2;
        // Machine whirlpoolFridge = new HomeAppliance("fridge", fridgeKilojoulesPerHour);
        // var drillKilojoulesPerHour = 2160;
        // Machine boschImpactDrill = new FactoryEquipment("fridge", drillKilojoulesPerHour);
        // printfn("Venue Type: %s", hondaVenue.getType());
        // printfn("Venue Fuel Type: %s", hondaVenue.getFuelType());
        // printfn("Venue Energy Consumption: %f kmpl", hondaVenue.getEnergyConsumption());
        // ur);
        // printfn("Venue Type: %s", hondaVenue.getType());
        // printfn("Venue Fuel Type: %s", hondaVenue.getFuelType());
        // printfn("Venue Energy Consumption: %f kmpl", hondaVenue.getEnergyConsumption());
    }
}
