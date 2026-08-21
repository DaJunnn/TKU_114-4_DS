import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServiceCenterWorkflow {

    static class ServiceTicket {
        private String id;
        private String customerName;
        private String issue;
        private String status;

        public ServiceTicket(String id, String customerName, String issue) {
            this.id = id;
            this.customerName = customerName;
            this.issue = issue;
            this.status = "WAITING";
        }

        public String getId() {
            return id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String toString() {
            return id + " - " + customerName + " - " + issue + " - " + status;
        }
    }

    private Map<String, ServiceTicket> ticketMap = new HashMap<>();
    private Deque<ServiceTicket> waitingQueue = new ArrayDeque<>();
    private Deque<ServiceTicket> completedStack = new ArrayDeque<>();
    private Set<String> ticketIds = new HashSet<>();

    public void createTicket(String id, String customerName, String issue) {
        if (ticketIds.contains(id)) {
            System.out.println("Duplicate ticket id: " + id);
            return;
        }

        ServiceTicket ticket = new ServiceTicket(id, customerName, issue);

        ticketMap.put(id, ticket);
        ticketIds.add(id);
        waitingQueue.offerLast(ticket);

        System.out.println("Created: " + ticket);
    }

    public void processNext() {
        ServiceTicket ticket = waitingQueue.pollFirst();

        if (ticket == null) {
            System.out.println("Waiting queue is empty.");
            return;
        }

        ticket.setStatus("COMPLETED");
        completedStack.push(ticket);

        System.out.println("Completed: " + ticket);
    }

    public void cancelWaiting(String id) {
        ServiceTicket ticket = ticketMap.get(id);

        if (ticket == null) {
            System.out.println("Ticket not found: " + id);
            return;
        }

        if (!ticket.getStatus().equals("WAITING")) {
            System.out.println("Only waiting ticket can be cancelled: " + id);
            return;
        }

        boolean removed = waitingQueue.remove(ticket);

        if (removed) {
            ticket.setStatus("CANCELLED");
            System.out.println("Cancelled: " + ticket);
        }
    }

    public void undoLastCompletion() {
        ServiceTicket ticket = completedStack.pollFirst();

        if (ticket == null) {
            System.out.println("No completed ticket to undo.");
            return;
        }

        ticket.setStatus("WAITING");
        waitingQueue.offerFirst(ticket);

        System.out.println("Undo completion: " + ticket);
    }

    public void findById(String id) {
        ServiceTicket ticket = ticketMap.get(id);

        if (ticket == null) {
            System.out.println("Ticket not found: " + id);
        } else {
            System.out.println("Found: " + ticket);
        }
    }

    public void printSummary() {
        System.out.println("Total tickets: " + ticketMap.size());
        System.out.println("Waiting: " + waitingQueue.size());
        System.out.println("Completed: " + completedStack.size());

        int cancelled = 0;

        for (ServiceTicket ticket : ticketMap.values()) {
            if (ticket.getStatus().equals("CANCELLED")) {
                cancelled++;
            }
        }

        System.out.println("Cancelled: " + cancelled);
        System.out.println("Waiting queue: " + waitingQueue);
        System.out.println("Completed stack: " + completedStack);
        System.out.println();
    }

    public static void main(String[] args) {

        ServiceCenterWorkflow system = new ServiceCenterWorkflow();

        system.createTicket("T001", "Amy", "Computer problem");
        system.createTicket("T002", "Bob", "Network problem");
        system.createTicket("T003", "Cindy", "Printer problem");

        system.createTicket("T001", "David", "Duplicate test");

        system.printSummary();

        system.processNext();
        system.processNext();

        system.printSummary();

        system.undoLastCompletion();

        system.printSummary();

        system.cancelWaiting("T003");

        system.findById("T001");
        system.findById("T999");

        system.processNext();
        system.processNext();
        system.processNext();

        system.undoLastCompletion();
        system.undoLastCompletion();
        system.undoLastCompletion();

        system.printSummary();
    }
}