public class StudentManagement {
    Student[] students = new Student[100];
    int num = 0;

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    void addStudent(Student newStudent) {
        if (newStudent != null) {
            students[num] = newStudent;
            num++;
        }
    }

    String studentsByGroup() {
        String p = "";
        String gr = "";
        int count = 0;
        boolean[] check = new boolean[num];
        for (int i = 0; i < num; i++) {
            check[i] = false;
        }
        while (count < num) {
            for (int i = 0; i < num; i++) {
                if (!check[i]) {
                    gr = students[i].getGroup();
                    p = p + gr + "\n";
                    for (int j = i; j < num; j++) {
                        if (students[j].getGroup().equals(gr)) {
                            p = p + students[j].getInfo() + "\n";
                            check[j] = true;
                            count++;
                        }
                    }
                }
            }
        }
        return p;
    }

    void removeStudent(String id) {
        if (num == 0) {
            return;
        }
        for (int i = 0; i < num - 1; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i + 1; j < num; j++) {
                    students[j - 1] = students[j];
                }
                num--;
                students[num] = null;
                return;
            }
        }
        if (students[num - 1].getId().equals(id)) {
            num--;
            students[num] = null;
        }
    }

}
