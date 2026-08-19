interface PricingPolicy {
    double calculatePrice(double originalPrice);
    String getName();
}

class OriginalPricePolicy implements PricingPolicy {
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice;
    }

    @Override
    public String getName() {
        return "原價";
    }
}

class VipDiscountPolicy implements PricingPolicy {
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice * 0.85;
    }

    @Override
    public String getName() {
        return "VIP 八五折";
    }
}

class Over2000DiscountPolicy implements PricingPolicy {
    @Override
    public double calculatePrice(double originalPrice) {
        if (originalPrice >= 2000) {
            return originalPrice - 300;
        }
        return originalPrice;
    }

    @Override
    public String getName() {
        return "滿 2000 折 300";
    }
}

interface NotificationChannel {
    boolean send(String receiver, String message);
    String getName();
}

class EmailChannel implements NotificationChannel {
    @Override
    public boolean send(String receiver, String message) {
        System.out.println("[Email] 傳送給 " + receiver + "：" + message);
        return true;
    }

    @Override
    public String getName() {
        return "Email";
    }
}

class SmsChannel implements NotificationChannel {
    @Override
    public boolean send(String receiver, String message) {
        System.out.println("[SMS] 傳送給 " + receiver + "：" + message);
        return true;
    }

    @Override
    public String getName() {
        return "SMS";
    }
}

class ConsoleChannel implements NotificationChannel {
    @Override
    public boolean send(String receiver, String message) {
        System.out.println("[Console] " + receiver + "：" + message);
        return true;
    }

    @Override
    public String getName() {
        return "Console";
    }
}

class CheckoutResult {
    private String orderId;
    private double originalPrice;
    private double finalPrice;
    private boolean notificationStatus;

    public CheckoutResult(
            String orderId,
            double originalPrice,
            double finalPrice,
            boolean notificationStatus) {

        this.orderId = orderId;
        this.originalPrice = originalPrice;
        this.finalPrice = finalPrice;
        this.notificationStatus = notificationStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public boolean isNotificationStatus() {
        return notificationStatus;
    }
}

class CheckoutService {
    private PricingPolicy pricingPolicy;
    private NotificationChannel notificationChannel;

    public CheckoutService(
            PricingPolicy pricingPolicy,
            NotificationChannel notificationChannel) {

        this.pricingPolicy = pricingPolicy;
        this.notificationChannel = notificationChannel;
    }

    public CheckoutResult checkout(
            String orderId,
            double originalPrice,
            String receiver) {

        if (originalPrice < 0) {
            originalPrice = 0;
        }

        double finalPrice =
                pricingPolicy.calculatePrice(originalPrice);

        String message =
                "訂單 " + orderId +
                "，原價：" + originalPrice +
                "，結帳價：" + finalPrice;

        boolean notificationStatus =
                notificationChannel.send(receiver, message);

        return new CheckoutResult(
                orderId,
                originalPrice,
                finalPrice,
                notificationStatus
        );
    }
}

public class FlexibleCheckoutSystem {

    public static void testCheckout(
            String orderId,
            double price,
            PricingPolicy pricingPolicy,
            NotificationChannel channel) {

        CheckoutService service =
                new CheckoutService(pricingPolicy, channel);

        CheckoutResult result =
                service.checkout(orderId, price, "customer");

        System.out.println("訂單：" + result.getOrderId());
        System.out.println("計價方式：" + pricingPolicy.getName());
        System.out.println("通知方式：" + channel.getName());
        System.out.println("原價：" + result.getOriginalPrice());
        System.out.println("最終價格：" + result.getFinalPrice());
        System.out.println(
                "通知狀態：" +
                (result.isNotificationStatus() ? "成功" : "失敗")
        );
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        testCheckout(
                "A001",
                1000,
                new OriginalPricePolicy(),
                new EmailChannel()
        );

        testCheckout(
                "A002",
                1000,
                new VipDiscountPolicy(),
                new SmsChannel()
        );

        testCheckout(
                "A003",
                2500,
                new Over2000DiscountPolicy(),
                new ConsoleChannel()
        );

        testCheckout(
                "A004",
                3000,
                new OriginalPricePolicy(),
                new SmsChannel()
        );

        testCheckout(
                "A005",
                2000,
                new VipDiscountPolicy(),
                new ConsoleChannel()
        );

        testCheckout(
                "A006",
                1800,
                new Over2000DiscountPolicy(),
                new EmailChannel()
        );
    }
}