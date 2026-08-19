interface DeliveryMethod {
    double calculateFee(double distance);
    String getEstimatedTime(double distance);
    String getName();
}

class HomeDelivery implements DeliveryMethod {
    @Override
    public double calculateFee(double distance) {
        return 60 + distance * 5;
    }

    @Override
    public String getEstimatedTime(double distance) {
        return "約 1～2 天";
    }

    @Override
    public String getName() {
        return "宅配";
    }
}

class StorePickup implements DeliveryMethod {
    @Override
    public double calculateFee(double distance) {
        return 30;
    }

    @Override
    public String getEstimatedTime(double distance) {
        return "約 1 天";
    }

    @Override
    public String getName() {
        return "超商取貨";
    }
}

class SelfPickup implements DeliveryMethod {
    @Override
    public double calculateFee(double distance) {
        return 0;
    }

    @Override
    public String getEstimatedTime(double distance) {
        return "可立即自取";
    }

    @Override
    public String getName() {
        return "自取";
    }
}

class OrderService {
    private DeliveryMethod deliveryMethod;

    public OrderService(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void showDeliveryInfo(double distance) {
        System.out.println("配送方式：" + deliveryMethod.getName());
        System.out.println("配送費用：" + deliveryMethod.calculateFee(distance) + " 元");
        System.out.println("預估時間：" + deliveryMethod.getEstimatedTime(distance));
        System.out.println();
    }
}

public class DeliveryStrategySystem {
    public static void main(String[] args) {
        double distance = 10;

        OrderService order = new OrderService(new HomeDelivery());
        order.showDeliveryInfo(distance);

        order.setDeliveryMethod(new StorePickup());
        order.showDeliveryInfo(distance);

        order.setDeliveryMethod(new SelfPickup());
        order.showDeliveryInfo(distance);
    }
}