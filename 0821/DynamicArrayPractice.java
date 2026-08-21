public class DynamicArrayPractice {

    static class DynamicArray<T> {
        private Object[] data;
        private int size;

        public DynamicArray() {
            data = new Object[2];
            size = 0;
        }

        public void add(T value) {
            ensureCapacity();
            data[size] = value;
            size++;
        }

        public void add(int index, T value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }

            ensureCapacity();

            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }

            data[index] = value;
            size++;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            checkIndex(index);
            return (T) data[index];
        }

        public void set(int index, T value) {
            checkIndex(index);
            data[index] = value;
        }

        @SuppressWarnings("unchecked")
        public T remove(int index) {
            checkIndex(index);

            T removedValue = (T) data[index];

            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }

            data[size - 1] = null;
            size--;

            return removedValue;
        }

        public int size() {
            return size;
        }

        public int capacity() {
            return data.length;
        }

        private void ensureCapacity() {
            if (size == data.length) {
                Object[] newData = new Object[data.length * 2];

                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }

                data = newData;
            }
        }

        private void checkIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }
        }

        public void print() {
            System.out.print("[");

            for (int i = 0; i < size; i++) {
                System.out.print(data[i]);

                if (i < size - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        DynamicArray<String> stringArray = new DynamicArray<>();

        stringArray.add("Apple");
        stringArray.add("Banana");
        stringArray.add("Cherry");

        stringArray.print();
        System.out.println("Size: " + stringArray.size());
        System.out.println("Capacity: " + stringArray.capacity());

        stringArray.add(1, "Orange");
        stringArray.print();

        System.out.println("Get index 2: " + stringArray.get(2));

        stringArray.set(2, "Grape");
        stringArray.print();

        System.out.println("Removed: " + stringArray.remove(1));
        stringArray.print();

        System.out.println();

        DynamicArray<Integer> integerArray = new DynamicArray<>();

        integerArray.add(10);
        integerArray.add(20);
        integerArray.add(30);
        integerArray.add(integerArray.size(), 40);

        integerArray.print();
        System.out.println("Size: " + integerArray.size());
        System.out.println("Capacity: " + integerArray.capacity());

        System.out.println("Removed last: " + integerArray.remove(integerArray.size() - 1));
        integerArray.print();

        try {
            integerArray.get(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            integerArray.get(integerArray.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}