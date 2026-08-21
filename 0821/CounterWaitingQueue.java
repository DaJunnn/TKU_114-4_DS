import java.util.ArrayDeque;
import java.util.Deque;

public class CounterWaitingQueue {

    static class Customer {
        private String name;

        public Customer(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    private Deque<Customer> queue = new ArrayDeque<>();

    public void addCustomer(String name) {
        Customer customer = new Customer(name);
        queue.offer(customer);
        System.out.println(name + " joined the queue.");
    }

    public void nextCustomer() {
        Customer customer = queue.peek();

        if (customer == null) {
            System.out.println("No customer is waiting.");
        } else {
            System.out.println("Next customer: " + customer);
        }
    }

    public void serveCustomer() {
        Customer customer = queue.poll();

        if (customer == null) {
            System.out.println("No customer to serve.");
        } else {
            System.out.println("Serving: " + customer);
        }
    }

    public void showWaitingCount() {
        System.out.println("Waiting customers: " + queue.size());
    }

    public static void main(String[] args) {

        CounterWaitingQueue counter = new CounterWaitingQueue();

        counter.addCustomer("Amy");
        counter.addCustomer("Bob");
        counter.addCustomer("Cindy");

        counter.showWaitingCount();
        counter.nextCustomer();

        counter.serveCustomer();

        counter.nextCustomer();
        counter.showWaitingCount();

        counter.serveCustomer();
        counter.serveCustomer();
        counter.serveCustomer();

        counter.showWaitingCount();
    }
}