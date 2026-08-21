public class GenericArrayStackDemo {

    static class ArrayStack<T> {
        private T[] stack;
        private int top;
        private int capacity;

        @SuppressWarnings("unchecked")
        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.stack = (T[]) new Object[capacity];
            this.top = -1;
        }

        public void push(T item) {
            if (isFull()) {
                System.out.println("Stack is full.");
                return;
            }

            stack[++top] = item;
        }

        public T pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return null;
            }

            T item = stack[top];
            stack[top] = null;
            top--;
            return item;
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return null;
            }

            return stack[top];
        }

        public int size() {
            return top + 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }
    }

    public static void main(String[] args) {

        ArrayStack<String> stringStack = new ArrayStack<>(3);

        stringStack.push("Apple");
        stringStack.push("Banana");
        stringStack.push("Cherry");

        System.out.println("String Stack");
        System.out.println("Peek: " + stringStack.peek());
        System.out.println("Size: " + stringStack.size());
        System.out.println("Is empty: " + stringStack.isEmpty());
        System.out.println("Is full: " + stringStack.isFull());
        System.out.println("Pop: " + stringStack.pop());
        System.out.println("Pop: " + stringStack.pop());

        ArrayStack<Integer> integerStack = new ArrayStack<>(3);

        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(30);

        System.out.println("\nInteger Stack");
        System.out.println("Peek: " + integerStack.peek());
        System.out.println("Size: " + integerStack.size());
        System.out.println("Is empty: " + integerStack.isEmpty());
        System.out.println("Is full: " + integerStack.isFull());
        System.out.println("Pop: " + integerStack.pop());
        System.out.println("Pop: " + integerStack.pop());
    }
}