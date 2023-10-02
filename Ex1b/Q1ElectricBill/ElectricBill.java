package Ex1b.Q1ElectricBill;

import java.util.Scanner;

record BlockRate(double lowerBound, double rate) {}

class Consumer {
    enum Type {
         DOMESTIC, COMMERCIAL
    }
    private String number;
    private String name;
    private Type type;
    private double prevMonthReading;
    private double curMonthReading;

    public Consumer(String number, String name, Type type, double curMonthReading, double prevMonthReading) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.prevMonthReading = prevMonthReading;
        this.curMonthReading = curMonthReading;
    }

    public Consumer(String number, String name, Type type) {
        this(number, name, type, 0, 0);  
    }

    public double calculateBill() {
        double bill = 0;
        double amtReadingToProcess = curMonthReading;
        BlockRate[] rates = null;
        switch(type){
            case DOMESTIC:
                rates = new BlockRate[]{new BlockRate(500, 6), new BlockRate(200, 4), new BlockRate(100, 2.5), new BlockRate(0, 1)};
                break;
            case COMMERCIAL:
                rates = new BlockRate[]{new BlockRate(500, 7), new BlockRate(200, 6), new BlockRate(100, 4.5), new BlockRate(0, 2)};
                break;
        }

        for(BlockRate rate : rates) {
            if (rate.lowerBound() > amtReadingToProcess) 
                continue;
            bill += (amtReadingToProcess - rate.lowerBound())*rate.rate();
            amtReadingToProcess = rate.lowerBound();
        }
            
        return bill;
    }

    public String toString() {
        String format_str =  """
            Number: %s
            Name: %s
            Type of Connection: %s
            Previous Month's Reading: %f
            Current Month's Reading: %f
            Bill for this Month: %f
        """;
        return String.format(format_str, number, name, type.toString(), prevMonthReading, curMonthReading, calculateBill());
    }
}

public class ElectricBill {
    public static void print(Object obj) {
        System.out.print(obj);
    }
    
    public static void println(Object obj) {
        System.out.println(obj);
    }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        println("Enter the following customer information: ");
        print("Enter number: ");
        String number = sc.nextLine();
        print("Enter name: ");
        String name = sc.nextLine();
        print("Enter type of connection(domestic/commercial): ");
        String typeStr = sc.nextLine();
        Consumer.Type type = null;
        switch(typeStr.toLowerCase()) {
            case "domestic":
                type = Consumer.Type.DOMESTIC;
                break;
            case "commercial":
                type = Consumer.Type.COMMERCIAL;
                break;
        }
        print("Enter previous month's reading: ");
        double prevMonthReading = sc.nextDouble();
        sc.nextLine();
        print("Enter current month's reading: ");
        double curMonthReading = sc.nextDouble();
        sc.nextLine();
        var consumer = new Consumer(number, name, type, curMonthReading, prevMonthReading);
        println(consumer.toString());
    }
}
