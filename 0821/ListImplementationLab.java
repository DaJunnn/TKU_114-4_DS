import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListImplementationLab {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("=== ArrayList ===");
        testList(arrayList);

        System.out.println("\n=== LinkedList ===");
        testList(linkedList);

        System.out.println("\n=== Comparison ===");
        System.out.println("ArrayList is usually faster for random access because it uses an array internally.");
        System.out.println("LinkedList may be more suitable for frequent insertions or deletions at the ends.");
        System.out.println("Searching both lists is generally O(n).");
    }

    public static void testList(List<Integer> list) {

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("After adding: " + list);

        list.add(2, 25);
        System.out.println("After inserting 25 at index 2: " + list);

        int target = 30;
        int index = list.indexOf(target);

        if (index != -1) {
            System.out.println(target + " found at index: " + index);
        } else {
            System.out.println(target + " not found");
        }

        list.remove(Integer.valueOf(20));
        System.out.println("After removing 20: " + list);

        int sum = 0;

        for (int number : list) {
            sum += number;
        }

        System.out.println("Sum: " + sum);
    }
}