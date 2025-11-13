import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Алексей Панфилов", "ГР-101", 1,
                Map.of("Математика", 4, "Физика", 3, "Информатика", 5)));

        students.add(new Student("Валентин Васильев", "ГР-102", 2,
                Map.of("Математика", 2, "Физика", 2, "Информатика", 3)));

        students.add(new Student("Анна Белая", "ГР-101", 1,
                Map.of("Математика", 5, "Физика", 4, "Информатика", 5)));

        students.add(new Student("Василиса Львова", "ГР-103", 3,
                Map.of("Математика", 3, "Физика", 3, "Информатика", 4)));

        students.add(new Student("Андрей Афонасьев", "ГР-102", 2,
                Map.of("Математика", 2, "Физика", 2, "Информатика", 2)));

        System.out.println("Исходный список студентов:");
        students.forEach(System.out::println);
        System.out.println();

        StudentManager.printStudents(students, 1);
        StudentManager.printStudents(students, 2);
        StudentManager.printStudents(students, 3);

        StudentManager.removeUnderperformingStudents(students);
        System.out.println("После отчисления студентов с средним баллом < 3:");
        students.forEach(System.out::println);
        System.out.println();

        StudentManager.promoteStudents(students);
        System.out.println("После перевода на следующий курс:");
        students.forEach(System.out::println);
        System.out.println();

        StudentManager.printStudents(students, 1);
        StudentManager.printStudents(students, 2);
        StudentManager.printStudents(students, 3);
        StudentManager.printStudents(students, 4);
    }
}
