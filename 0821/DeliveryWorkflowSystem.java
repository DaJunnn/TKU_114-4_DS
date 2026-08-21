import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DeliveryWorkflowSystem {

    static class Delivery {
        private String id;
        private String address;

        public Delivery(String id, String address) {
            this.id = id;
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public String toString() {
            return id + " - " + address;
        }
    }

    private Map<String, Delivery> deliveryMap = new HashMap<>();
    private Queue<Delivery> waitingQueue = new ArrayDeque<>();
    private Stack<Delivery> completedStack = new Stack<>();

    public void addDelivery(String id, String address) {
        if (deliveryMap.containsKey(id)) {
            System.out.println("Duplicate ID: " + id);
            return;
        }

        Delivery delivery = new Delivery(id, address);
        deliveryMap.put(id, delivery);
        waitingQueue.offer(delivery);

        System.out.println("Added: " + delivery);
    }

    public void processDelivery() {
        Delivery delivery = waitingQueue.poll();

        if (delivery == null) {
            System.out.println("No delivery waiting.");
            return;
        }

        completedStack.push(delivery);
        System.out.println("Completed: " + delivery);
    }

    public void undo() {
        if (completedStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Delivery delivery = completedStack.pop();
        waitingQueue.offer(delivery);

        System.out.println("Undo: " + delivery);
    }

    public void search(String id) {
        Delivery delivery = deliveryMap.get(id);

        if (delivery == null) {
            System.out.println("Delivery not found: " + id);
        } else {
            System.out.println("Found: " + delivery);
        }
    }

    public void showStatistics() {
        System.out.println("Total deliveries: " + deliveryMap.size());
        System.out.println("Waiting deliveries: " + waitingQueue.size());
        System.out.println("Completed deliveries: " + completedStack.size());
    }

    public void showWaiting() {
        System.out.println("Waiting queue: " + waitingQueue);
    }

    public void showCompleted() {
        System.out.println("Completed history: " + completedStack);
    }

    public static void main(String[] args) {

        DeliveryWorkflowSystem system = new DeliveryWorkflowSystem();

        system.addDelivery("D001", "Taipei");
        system.addDelivery("D002", "New Taipei");
        system.addDelivery("D003", "Taoyuan");

        system.addDelivery("D001", "Kaohsiung");

        system.showWaiting();

        system.search("D002");
        system.search("D999");

        system.processDelivery();
        system.processDelivery();

        system.showWaiting();
        system.showCompleted();

        system.undo();

        system.showWaiting();
        system.showCompleted();

        system.processDelivery();
        system.processDelivery();
        system.processDelivery();

        system.showStatistics();
    }
}