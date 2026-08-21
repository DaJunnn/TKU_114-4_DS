import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Enrollment {

    private String studentId;
    private String courseCode;

    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Enrollment other = (Enrollment) obj;

        return Objects.equals(studentId, other.studentId)
                && Objects.equals(courseCode, other.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseCode);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}

public class EnrollmentSetSystem {

    public static void main(String[] args) {

        Set<Enrollment> enrollments = new HashSet<>();

        Enrollment e1 = new Enrollment("S001", "JAVA");
        Enrollment e2 = new Enrollment("S001", "DATABASE");
        Enrollment e3 = new Enrollment("S002", "JAVA");
        Enrollment e4 = new Enrollment("S001", "JAVA");

        // 同一人可以加入不同課程
        boolean result1 = enrollments.add(e1);
        boolean result2 = enrollments.add(e2);

        // 不同人可以加入同一課程
        boolean result3 = enrollments.add(e3);

        // 同一人、同一課程不能重複
        boolean result4 = enrollments.add(e4);

        System.out.println("=== 新增結果 ===");
        System.out.println("加入 S001 JAVA: " + result1);
        System.out.println("加入 S001 DATABASE: " + result2);
        System.out.println("加入 S002 JAVA: " + result3);
        System.out.println("再次加入 S001 JAVA: " + result4);

        System.out.println();
        System.out.println("=== 目前報名資料 ===");

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        // 建立新的物件，但身分與 e1 相同
        Enrollment searchEnrollment =
                new Enrollment("S001", "JAVA");

        System.out.println();
        System.out.println("=== contains 測試 ===");

        boolean containsResult =
                enrollments.contains(searchEnrollment);

        System.out.println(
                "是否包含 S001 JAVA: " + containsResult
        );

        System.out.println();
        System.out.println("=== remove 測試 ===");

        boolean removeResult =
                enrollments.remove(searchEnrollment);

        System.out.println(
                "移除 S001 JAVA: " + removeResult
        );

        System.out.println();
        System.out.println("=== 移除後資料 ===");

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}