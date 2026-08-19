abstract class Transport {
    protected String routeName;

    public Transport(String routeName) {
        this.routeName = routeName;
    }

    public abstract int calculateFare(int distance);

    public String getRouteName() {
        return routeName;
    }
}

class Bus extends Transport {
    public Bus(String routeName) {
        super(routeName);
    }

    @Override
    public int calculateFare(int distance) {
        return 15 + distance * 2;
    }
}

class Taxi extends Transport {
    public Taxi(String routeName) {
        super(routeName);
    }

    @Override
    public int calculateFare(int distance) {
        return 85 + distance * 5;
    }
}

public class TransportFareSystem {
    public static void main(String[] args) {
        Transport[] transports = {
            new Bus("公車 307"),
            new Taxi("台北計程車"),
            new Bus("公車 299"),
            new Taxi("新北計程車")
        };

        int distance = 10;

        for (Transport transport : transports) {
            System.out.println(
                transport.getRouteName() +
                "，距離：" + distance +
                " 公里，票價：" +
                transport.calculateFare(distance) +
                " 元"
            );
        }
    }
}