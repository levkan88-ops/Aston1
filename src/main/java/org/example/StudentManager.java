import java.util.*;

public class StudentManager {

    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.promoteToNextCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName() + " (группа: " + student.getGroup() +
                        ", средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("На " + course + " курсе нет студентов.");
        }
        System.out.println();
    }
}
