import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EnrollmentCleanup {

    public static void main(String[] args) {

        List<String> students = new ArrayList<>();

        students.add("Amy");
        students.add("Bob");
        students.add("");
        students.add("Tom");
        students.add(null);
        students.add("Amy");
        students.add("   ");
        students.add("John");
        students.add("Bob");
        students.add("Mary");

        System.out.println("=== 清理前 ===");
        System.out.println(students);

        // 使用 Iterator 移除 null、空字串、只有空白的資料
        Iterator<String> iterator = students.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();

            if (name == null || name.trim().isEmpty()) {
                iterator.remove();
            }
        }

        System.out.println();
        System.out.println("=== 清理後 ===");
        System.out.println(students);

        // 使用 Set 找出重複姓名
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String name : students) {
            if (!seen.add(name)) {
                duplicates.add(name);
            }
        }

        System.out.println();
        System.out.println("=== 重複姓名報告 ===");

        if (duplicates.isEmpty()) {
            System.out.println("沒有重複姓名");
        } else {
            for (String name : duplicates) {
                System.out.println(name);
            }
        }
    }
}