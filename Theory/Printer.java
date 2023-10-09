package Theory;

class Cartridge {
    private String type;
    Cartridge(String t) {
        type = t;
    }

    public String getType() {
        return type;
    }
}

public class Printer {
    private String type = "laser";
    Cartridge c1 = new Cartridge("Color");
    Cartridge c2 = new Cartridge("B&W");
    public String getPrinterType() {
        return type;
    }
}

class Main {
    public static void main(String[] args) {
        var printer = new Printer();
        System.out.println(printer.getPrinterType());
    }
}
