public class CustomerOrderSystem {

    static class Customer {
        private String customerId;
        private String name;

        public Customer(String customerId, String name) {
            this.customerId = customerId;
            this.name = name;
        }

        public String getCustomerId() {
            return customerId;
        }

        public String getName() {
            return name;
        }
    }

    static class OrderItem {
        private String productName;
        private double price;
        private int quantity;

        public OrderItem(String productName, double price, int quantity) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public double getSubtotal() {
            return price * quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return productName
                    + "，單價：" + price
                    + "，數量：" + quantity
                    + "，小計：" + getSubtotal();
        }
    }

    static class CustomerOrder {
        private String orderId;
        private Customer customer;
        private OrderItem[] items;

        public CustomerOrder(String orderId, Customer customer, OrderItem[] items) {
            this.orderId = orderId;
            this.customer = customer;
            this.items = items;
        }

        public double getTotalAmount() {
            double total = 0;

            for (OrderItem item : items) {
                total += item.getSubtotal();
            }

            return total;
        }

        public int getTotalQuantity() {
            int total = 0;

            for (OrderItem item : items) {
                total += item.getQuantity();
            }

            return total;
        }

        public String summary() {
            String result = "訂單編號：" + orderId
                    + "\n顧客編號：" + customer.getCustomerId()
                    + "\n顧客姓名：" + customer.getName()
                    + "\n===== 訂單品項 =====\n";

            for (OrderItem item : items) {
                result += item + "\n";
            }

            result += "品項總數量：" + getTotalQuantity()
                    + "\n訂單總額：" + getTotalAmount();

            return result;
        }
    }

    public static void main(String[] args) {

        Customer customer = new Customer("C001", "王小明");

        OrderItem[] items = {
            new OrderItem("鍵盤", 1200, 1),
            new OrderItem("滑鼠", 800, 2),
            new OrderItem("耳機", 1500, 1)
        };

        CustomerOrder order =
                new CustomerOrder("O001", customer, items);

        System.out.println(order.summary());
    }
}