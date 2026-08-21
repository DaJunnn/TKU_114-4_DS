public class GenericArrayTools {

    public static <T> int countMatches(T[] data, T target) {
        if (data == null) {
            return 0;
        }

        int count = 0;

        for (T item : data) {
            if (target == null) {
                if (item == null) {
                    count++;
                }
            } else {
                if (target.equals(item)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static <T> T last(T[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        return data[data.length - 1];
    }

    public static <T> void swap(T[] data, int first, int second) {
        if (data == null) {
            return;
        }

        if (first < 0 || second < 0 ||
            first >= data.length || second >= data.length) {
            return;
        }

        T temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    public static void main(String[] args) {

        String[] names = {"Tom", "Amy", "Tom", "John"};

        System.out.println("Tom 出現次數：" +
                countMatches(names, "Tom"));

        System.out.println("最後一個元素：" +
                last(names));

        swap(names, 0, 3);

        System.out.println("交換後：");
        for (String name : names) {
            System.out.println(name);
        }

        Integer[] numbers = {10, 20, 30, 20, 20};

        System.out.println("20 出現次數：" +
                countMatches(numbers, 20));

        System.out.println("最後一個數字：" +
                last(numbers));

        swap(numbers, 0, 4);

        System.out.println("交換後：");
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}