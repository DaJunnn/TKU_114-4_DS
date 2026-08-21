public class LinkedTaskListSystem {

    static class Task {
        String id;
        String name;

        public Task(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return id + " - " + name;
        }
    }

    static class TaskNode {
        Task task;
        TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class TaskLinkedList {
        private TaskNode head;
        private int size;

        public void addFirst(Task task) {
            if (findById(task.id) != null) {
                System.out.println("Duplicate id: " + task.id);
                return;
            }

            TaskNode newNode = new TaskNode(task);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void addLast(Task task) {
            if (findById(task.id) != null) {
                System.out.println("Duplicate id: " + task.id);
                return;
            }

            TaskNode newNode = new TaskNode(task);

            if (head == null) {
                head = newNode;
            } else {
                TaskNode current = head;

                while (current.next != null) {
                    current = current.next;
                }

                current.next = newNode;
            }

            size++;
        }

        public Task findById(String id) {
            TaskNode current = head;

            while (current != null) {
                if (current.task.id.equals(id)) {
                    return current.task;
                }

                current = current.next;
            }

            return null;
        }

        public void removeById(String id) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.task.id.equals(id)) {
                head = head.next;
                size--;
                System.out.println("Removed: " + id);
                return;
            }

            TaskNode current = head;

            while (current.next != null) {
                if (current.next.task.id.equals(id)) {
                    current.next = current.next.next;
                    size--;
                    System.out.println("Removed: " + id);
                    return;
                }

                current = current.next;
            }

            System.out.println("Task not found: " + id);
        }

        public void insertAfter(String existingId, Task task) {
            if (findById(task.id) != null) {
                System.out.println("Duplicate id: " + task.id);
                return;
            }

            TaskNode current = head;

            while (current != null) {
                if (current.task.id.equals(existingId)) {
                    TaskNode newNode = new TaskNode(task);
                    newNode.next = current.next;
                    current.next = newNode;
                    size++;
                    return;
                }

                current = current.next;
            }

            System.out.println("Task not found: " + existingId);
        }

        public int size() {
            return size;
        }

        public void printAll() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            TaskNode current = head;

            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        System.out.println("Empty list test:");
        list.printAll();
        list.removeById("T001");

        System.out.println();

        list.addLast(new Task("T001", "Homework"));
        list.addLast(new Task("T002", "Study Java"));
        list.addLast(new Task("T003", "Prepare Report"));
        list.addLast(new Task("T004", "Meeting"));

        list.printAll();
        System.out.println("Size: " + list.size());

        System.out.println();

        list.addLast(new Task("T002", "Duplicate Task"));

        System.out.println();

        list.insertAfter("T002", new Task("T005", "Practice Coding"));
        list.printAll();

        System.out.println();

        System.out.println("Find T003: " + list.findById("T003"));
        System.out.println("Find T999: " + list.findById("T999"));

        System.out.println();

        list.removeById("T001");
        list.printAll();

        System.out.println();

        list.removeById("T003");
        list.printAll();

        System.out.println();

        list.removeById("T004");
        list.printAll();

        System.out.println();

        list.removeById("T999");

        System.out.println("Final size: " + list.size());
    }
}