import java.util.ArrayList;
import java.util.List;

public class WildcardNumberTools {

    public static double average(List<? extends Number> values) {
        if (values == null || values.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;

        for (Number value : values) {
            sum += value.doubleValue();
        }

        return sum / values.size();
    }

    public static double maximum(List<? extends Number> values) {
        if (values == null || values.isEmpty()) {
            return Double.NaN;
        }

        double max = values.get(0).doubleValue();

        for (Number value : values) {
            if (value.doubleValue() > max) {
                max = value.doubleValue();
            }
        }

        return max;
    }

    public static void addRange(
            List<? super Integer> target,
            int start,
            int end) {

        if (target == null || start > end) {
            return;
        }

        for (int i = start; i <= end; i++) {
            target.add(i);
        }
    }

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);

        List<Double> doubles = new ArrayList<>();
        doubles.add(1.5);
        doubles.add(2.5);
        doubles.add(3.5);

        System.out.println("Integer average: " + average(integers));
        System.out.println("Integer maximum: " + maximum(integers));

        System.out.println();

        System.out.println("Double average: " + average(doubles));
        System.out.println("Double maximum: " + maximum(doubles));

        System.out.println();

        List<Integer> numbers = new ArrayList<>();
        addRange(numbers, 1, 5);

        System.out.println("addRange 1~5:");
        System.out.println(numbers);

        System.out.println();

        List<Integer> emptyList = new ArrayList<>();

        System.out.println("空 List average: " + average(emptyList));
        System.out.println("空 List maximum: " + maximum(emptyList));

        System.out.println();

        addRange(numbers, 10, 5);
        System.out.println("start > end 後:");
        System.out.println(numbers);
    }
}