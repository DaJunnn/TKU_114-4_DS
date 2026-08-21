import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordIndexSystem {

    public static void main(String[] args) {

        String[] sentences = {
            "Java is easy, Java is useful.",
            "Python is useful, and Java is popular.",
            "JAVA is powerful."
        };

        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();

        for (String sentence : sentences) {

            // 轉成小寫
            sentence = sentence.toLowerCase();

            // 移除逗號與句號
            sentence = sentence.replace(",", "");
            sentence = sentence.replace(".", "");

            // 用空白切割成單字
            String[] words = sentence.split("\\s+");

            for (String word : words) {

                uniqueWords.add(word);

                wordCount.put(
                    word,
                    wordCount.getOrDefault(word, 0) + 1
                );
            }
        }

        System.out.println("=== 不重複單字 ===");

        for (String word : uniqueWords) {
            System.out.println(word);
        }

        System.out.println();

        System.out.println("=== 出現至少兩次的單字 ===");

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {

            if (entry.getValue() >= 2) {
                System.out.println(
                    entry.getKey() + " : " + entry.getValue()
                );
            }
        }
    }
}