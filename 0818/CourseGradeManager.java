public class CourseGradeManager {

    static class CourseGrade {
        private String studentId;
        private String name;
        private double regularScore;
        private double midtermScore;
        private double finalExamScore;
        private double attendanceScore;

        public CourseGrade(String studentId, String name,
                           double regularScore,
                           double midtermScore,
                           double finalExamScore,
                           double attendanceScore) {

            this.studentId = studentId;
            this.name = name;
            this.regularScore = validScore(regularScore);
            this.midtermScore = validScore(midtermScore);
            this.finalExamScore = validScore(finalExamScore);
            this.attendanceScore = validScore(attendanceScore);
        }

        private double validScore(double score) {
            if (score < 0) {
                return 0;
            }

            if (score > 100) {
                return 100;
            }

            return score;
        }

        public double calculateFinalScore() {
            return regularScore * 0.5
                    + midtermScore * 0.2
                    + finalExamScore * 0.2
                    + attendanceScore * 0.1;
        }

        public String getLevel() {
            double score = calculateFinalScore();

            if (score >= 90) {
                return "A";
            } else if (score >= 80) {
                return "B";
            } else if (score >= 70) {
                return "C";
            } else if (score >= 60) {
                return "D";
            } else {
                return "F";
            }
        }

        public String getStudentId() {
            return studentId;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "學號：" + studentId
                    + "，姓名：" + name
                    + "，平時：" + regularScore
                    + "，期中：" + midtermScore
                    + "，期末：" + finalExamScore
                    + "，出席：" + attendanceScore
                    + "，總成績：" + calculateFinalScore()
                    + "，等第：" + getLevel();
        }
    }

    public static void main(String[] args) {

        CourseGrade[] students = {
            new CourseGrade("S001", "王小明", 90, 85, 88, 100),
            new CourseGrade("S002", "李小華", 75, 70, 80, 90),
            new CourseGrade("S003", "陳大明", 60, 55, 58, 80),
            new CourseGrade("S004", "林小美", 95, 92, 96, 100),
            new CourseGrade("S005", "張志豪", 50, 45, 55, 70)
        };

        System.out.println("===== 所有學生成績 =====");

        for (CourseGrade student : students) {
            System.out.println(student);
        }

        double total = 0;

        for (CourseGrade student : students) {
            total += student.calculateFinalScore();
        }

        double average = total / students.length;

        System.out.println("\n平均成績：" + average);

        CourseGrade highest = students[0];

        for (CourseGrade student : students) {
            if (student.calculateFinalScore() > highest.calculateFinalScore()) {
                highest = student;
            }
        }

        System.out.println("\n===== 最高分 =====");
        System.out.println(highest);

        System.out.println("\n===== 及格名單 =====");

        for (CourseGrade student : students) {
            if (student.calculateFinalScore() >= 60) {
                System.out.println(
                        student.getStudentId()
                                + " "
                                + student.getName()
                                + " "
                                + student.calculateFinalScore()
                                + " "
                                + student.getLevel()
                );
            }
        }
    }
}