import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CollectionChoiceReport {

    public static void main(String[] args) {

        System.out.println("1. 保留搜尋紀錄且允許重複");
        List<String> searchHistory = new ArrayList<>();

        searchHistory.add("Java");
        searchHistory.add("Python");
        searchHistory.add("Java");

        System.out.println("Interface: List");
        System.out.println("Implementation: ArrayList");
        System.out.println("Result: " + searchHistory);
        System.out.println();

        System.out.println("2. 保存不重複會員編號");
        Set<String> memberIds = new HashSet<>();

        memberIds.add("M001");
        memberIds.add("M002");
        memberIds.add("M001");

        System.out.println("Interface: Set");
        System.out.println("Implementation: HashSet");
        System.out.println("Result: " + memberIds);
        System.out.println();

        System.out.println("3. 以學號查詢成績");
        Map<String, Integer> grades = new HashMap<>();

        grades.put("S001", 85);
        grades.put("S002", 92);
        grades.put("S003", 78);

        System.out.println("Interface: Map");
        System.out.println("Implementation: HashMap");
        System.out.println("S002 Grade: " + grades.get("S002"));
        System.out.println();

        System.out.println("4. 依到達順序處理列印工作");
        Queue<String> printQueue = new ArrayDeque<>();

        printQueue.offer("Document A");
        printQueue.offer("Document B");
        printQueue.offer("Document C");

        System.out.println("Interface: Queue");
        System.out.println("Implementation: ArrayDeque");

        while (!printQueue.isEmpty()) {
            System.out.println("Printing: " + printQueue.poll());
        }

        System.out.println();

        System.out.println("5. 復原最近操作");
        Deque<String> undoStack = new ArrayDeque<>();

        undoStack.push("Type A");
        undoStack.push("Delete B");
        undoStack.push("Insert C");

        System.out.println("Interface: Deque");
        System.out.println("Implementation: ArrayDeque");
        System.out.println("Undo: " + undoStack.pop());
        System.out.println("Undo: " + undoStack.pop());
    }
}