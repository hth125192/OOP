public class StudentManagementTest {
    public static void main(String []args) {
        StudentManagement list = new StudentManagement();

        Student A = new Student();
        A.setName("Nguyen Van An");
        A.setId("17020001");
        A.setGroup("K62CC");
        A.setEmail("17020001@vnu.edu.vn");

        Student B = new Student("Nguyen Van B", "17020002", "17020002@vnu.edu.vn");
        B.setGroup("K62CC");

        Student C = new Student("Nguyen Van C", "17020003", "17020003@vnu.edu.vn");

        Student D = new Student("Nguyen Van D", "17020004", "17020004@vnu.edu.vn");

        Student E = new Student(A);

        list.addStudent(A);
        list.addStudent(B);
        list.addStudent(C);
        list.addStudent(D);
        list.addStudent(E);

        System.out.println(list.studentsByGroup());

        list.removeStudent("17020002");

        System.out.println(list.studentsByGroup());
    }
}
