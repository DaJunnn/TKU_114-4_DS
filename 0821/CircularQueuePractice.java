public class CircularQueuePractice {

    static class CircularQueue<T> {
        private Object[] data;
        private int front;
        private int rear;
        private int size;

        public CircularQueue(int capacity) {
            data = new Object[capacity];
            front = 0;
            rear = 0;
            size = 0;
        }

        public void enqueue(T value) {
            if (isFull()) {
                System.out.println("Queue is full.");
                return;
            }

            data[rear] = value;
            rear = (rear + 1) % data.length;
            size++;
        }

        @SuppressWarnings("unchecked")
        public T dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return null;
            }

            T value = (T) data[front];
            data[front] = null;
            front = (front + 1) % data.length;
            size--;

            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == data.length;
        }

        public void printState() {
            System.out.print("Array: [");

            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);

                if (i < data.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
            System.out.println("front = " + front);
            System.out.println("rear = " + rear);
            System.out.println("size = " + size);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        CircularQueue<String> queue = new CircularQueue<>(4);

        queue.enqueue("A");
        queue.printState();

        queue.enqueue("B");
        queue.printState();

        queue.enqueue("C");
        queue.printState();

        System.out.println("Dequeue: " + queue.dequeue());
        queue.printState();

        System.out.println("Dequeue: " + queue.dequeue());
        queue.printState();

        queue.enqueue("D");
        queue.printState();

        queue.enqueue("E");
        queue.printState();

        queue.enqueue("F");
        queue.printState();

        System.out.println("Dequeue: " + queue.dequeue());
        queue.printState();

        queue.enqueue("G");
        queue.printState();

        System.out.println("FIFO result:");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
            queue.printState();
        }
    }
}