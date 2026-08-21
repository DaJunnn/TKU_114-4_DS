import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseTagReport {

    public static void main(String[] args) {

        String[] tags = {
            "Java",
            "AI",
            "Java",
            "Database",
            "AI",
            "Java"
        };

        List<String> tagList = new ArrayList<>();
        Set<String> tagSet = new HashSet<>();
        Map<String, Integer> tagCount = new HashMap<>();

        for (String tag : tags) {

            // List：保留原始順序，也允許重複
            tagList.add(tag);

            // Set：只保留不重複的標籤
            tagSet.add(tag);

            // Map：統計每個標籤出現次數
            tagCount.put(
                tag,
                tagCount.getOrDefault(tag, 0) + 1
            );
        }

        System.out.println("List 原始課程標籤：");
        System.out.println(tagList);

        System.out.println();

        System.out.println("Set 不重複課程標籤：");
        System.out.println(tagSet);

        System.out.println();

        System.out.println("Map 課程標籤出現次數：");
        System.out.println(tagCount);
    }
}