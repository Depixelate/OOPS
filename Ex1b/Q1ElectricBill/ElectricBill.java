package Ex1b.Q1ElectricBill;

import java.util.Scanner;

import static java.lang.System.out;

class BlockRate {
    private double lowerBound;
    private double rate;

    public BlockRate(double lowerBound, double rate) {
        this.lowerBound = lowerBound;
        this.rate = rate;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getRate() {
        return rate;
    }
}
//record BlockRate(double lowerBound, double rate) {}




class Consumer {
    // enum Type {
    //      DOMESTIC, COMMERCIAL
    // }
    private String number;
    private String name;
    private String type;
    private double prevMonthReading;
    private double curMonthReading;

    public Consumer(String number, String name, String type, double curMonthReading, double prevMonthReading) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.prevMonthReading = prevMonthReading;
        this.curMonthReading = curMonthReading;
    }

    public Consumer(String number, String name, String type) {
        this(number, name, type, 0, 0);  
    }

    public double calculateBill() {
        double bill = 0;
        double amtReadingToProcess = curMonthReading;
        
        BlockRate[] rates = null;
        switch(type.toUpperCase()){
            case "DOMESTIC":
                rates = new BlockRate[]{new BlockRate(500, 6), new BlockRate(200, 4), new BlockRate(100, 2.5), new BlockRate(0, 1)};
                break;
            case "COMMERCIAL":
                rates = new BlockRate[]{new BlockRate(500, 7), new BlockRate(200, 6), new BlockRate(100, 4.5), new BlockRate(0, 2)};
                break;
        }

        for(BlockRate rate : rates) {
            if (rate.getLowerBound() > amtReadingToProcess) 
                continue;
            bill += (amtReadingToProcess - rate.getLowerBound())*rate.getRate();
            amtReadingToProcess = rate.getLowerBound();
        }
            
        return bill;
    }

    public String toString() {
        String format_str =  "Number: %s\n"
            +"Name: %s\n"
            +"Type of Connection: %s\n"
            +"Previous Month's Reading: %f\n"
            +"Current Month's Reading: %f\n"
            +"Bill for this Month: %f\n";
        return String.format(format_str, number, name, type.toString(), prevMonthReading, curMonthReading, calculateBill());
    }
}

class Main {
    // public static void print(Object obj) {
    //     System.out.print(obj);
    // }
    
    // public static void println(Object obj) {
    //     System.out.println(obj);
    // }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        out.println("Enter the following customer information: ");
        out.print("Enter number: ");
        String number = sc.nextLine();
        out.print("Enter name: ");
        String name = sc.nextLine();
        out.print("Enter type of connection(domestic/commercial): ");
        String type = sc.nextLine();
        out.print("Enter previous month's reading: ");
        double prevMonthReading = sc.nextDouble();
        sc.nextLine();
        out.print("Enter current month's reading: ");
        double curMonthReading = sc.nextDouble();
        sc.nextLine();
        var consumer = new Consumer(number, name, type, curMonthReading, prevMonthReading);
        out.println(consumer.toString());
    }
}
