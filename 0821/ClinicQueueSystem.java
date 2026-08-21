import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ClinicQueueSystem {

    static class Patient {
        private String id;
        private String name;

        public Patient(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String toString() {
            return id + " - " + name;
        }
    }

    private Deque<Patient> queue = new ArrayDeque<>();

    public void register(String id, String name) {
        queue.offer(new Patient(id, name));
        System.out.println("Registered: " + id + " - " + name);
    }

    public void cancel(String id) {
        Iterator<Patient> iterator = queue.iterator();

        while (iterator.hasNext()) {
            Patient patient = iterator.next();

            if (patient.getId().equals(id)) {
                iterator.remove();
                System.out.println("Cancelled: " + patient);
                return;
            }
        }

        System.out.println("Patient not found: " + id);
    }

    public void callNext() {
        Patient patient = queue.poll();

        if (patient == null) {
            System.out.println("No patient waiting.");
        } else {
            System.out.println("Calling: " + patient);
        }
    }

    public void showNext() {
        Patient patient = queue.peek();

        if (patient == null) {
            System.out.println("No patient waiting.");
        } else {
            System.out.println("Next patient: " + patient);
        }
    }

    public void clearCompleted() {
        queue.clear();
        System.out.println("Queue cleared.");
    }

    public void showQueue() {
        System.out.println("Current queue: " + queue);
    }

    public static void main(String[] args) {

        ClinicQueueSystem clinic = new ClinicQueueSystem();

        clinic.register("P001", "Amy");
        clinic.register("P002", "Bob");
        clinic.register("P003", "Cindy");
        clinic.register("P004", "David");

        clinic.showQueue();
        clinic.showNext();

        clinic.cancel("P003");
        clinic.showQueue();

        clinic.callNext();
        clinic.showNext();

        clinic.callNext();
        clinic.callNext();

        clinic.showQueue();

        clinic.clearCompleted();
        clinic.showNext();
    }
}