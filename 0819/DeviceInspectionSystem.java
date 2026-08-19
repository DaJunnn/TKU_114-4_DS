abstract class Device {
    protected String name;

    public Device(String name) {
        this.name = name;
    }

    public abstract void runDiagnostic();
}

class Laptop extends Device {
    public Laptop(String name) {
        super(name);
    }

    @Override
    public void runDiagnostic() {
        System.out.println(name + "：執行筆電診斷");
    }
}

class Printer extends Device {
    public Printer(String name) {
        super(name);
    }

    @Override
    public void runDiagnostic() {
        System.out.println(name + "：執行印表機診斷");
    }

    public void cleanPrintHead() {
        System.out.println(name + "：清潔列印噴頭");
    }
}

class Router extends Device {
    public Router(String name) {
        super(name);
    }

    @Override
    public void runDiagnostic() {
        System.out.println(name + "：執行路由器診斷");
    }
}

public class DeviceInspectionSystem {
    public static void main(String[] args) {
        Device[] devices = {
            new Laptop("Laptop A"),
            new Printer("Printer A"),
            new Router("Router A"),
            new Printer("Printer B")
        };

        for (Device device : devices) {
            device.runDiagnostic();

            if (device instanceof Printer printer) {
                printer.cleanPrintHead();
            }
        }
    }
}