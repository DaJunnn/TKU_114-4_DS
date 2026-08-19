import java.util.Objects;

public class MemberEqualityPractice {

    static class LibraryMember {
        private String memberId;
        private String name;
        private String email;

        public LibraryMember(String memberId, String name, String email) {
            this.memberId = memberId;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "會員編號：" + memberId
                    + "，姓名：" + name
                    + "，Email：" + email;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (!(obj instanceof LibraryMember)) {
                return false;
            }

            LibraryMember other = (LibraryMember) obj;
            return Objects.equals(memberId, other.memberId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(memberId);
        }
    }

    public static void main(String[] args) {

        LibraryMember member1 =
                new LibraryMember("M001", "王小明", "ming@gmail.com");

        LibraryMember member2 =
                new LibraryMember("M001", "王小明", "different@gmail.com");

        System.out.println(member1);
        System.out.println(member2);

        System.out.println("\nmember1 == member2："
                + (member1 == member2));

        System.out.println("member1.equals(member2)："
                + member1.equals(member2));

        System.out.println("member1.equals(null)："
                + member1.equals(null));
    }
}