public class Main {
    public static void main(String[] args) {
        // Тестирование всех методов
        System.out.println("1. Метод printThreeWords():");
        printThreeWords();

        System.out.println("\n2. Метод checkSumSign():");
        checkSumSign();

        System.out.println("\n3. Метод printColor():");
        printColor();
        System.out.println("\n4. Метод compareNumbers():");
        compareNumbers();

        System.out.println("\n5. Метод checkSumRange(5, 10): " + checkSumRange(5, 10));
        System.out.println("   Метод checkSumRange(5, 5): " + checkSumRange(5, 5));
        System.out.println("   Метод checkSumRange(15, 10): " + checkSumRange(15, 10));

        System.out.println("\n6. Метод checkNumberSign():");
        checkNumberSign(10);
        checkNumberSign(-5);
        checkNumberSign(0);

        System.out.println("\n7. Метод isNegative():");
        System.out.println("   isNegative(10): " + isNegative(10));
        System.out.println("   isNegative(-5): " + isNegative(-5));
        System.out.println("   isNegative(0): " + isNegative(0));

        System.out.println("\n8. Метод printStringMultipleTimes():");
        printStringMultipleTimes("Hello", 3);

        System.out.println("\n9. Метод isLeapYear():");
        System.out.println("   2020 (високосный): " + isLeapYear(2020));
        System.out.println("   2021 (не високосный): " + isLeapYear(2021));
        System.out.println("   1900 (не високосный): " + isLeapYear(1900));
        System.out.println("   2000 (високосный): " + isLeapYear(2000));

        System.out.println("\n10. Метод invertArray():");
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(array10);
        System.out.print("   Результат: ");
        for (int num : array10) {
            System.out.print(num + " ");
        }

        System.out.println("\n\n11. Метод fillArray():");
        int[] array11 = fillArray();
        System.out.print("   Первые 10 элементов: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array11[i] + " ");
        }

        System.out.println("\n\n12. Метод processArray():");
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        processArray(array12);
        System.out.print("   Результат: ");
        for (int num : array12) {
            System.out.print(num + " ");
        }

        System.out.println("\n\n13. Метод fillDiagonal():");
        int[][] array13 = fillDiagonal(5);
        System.out.println("   Матрица 5x5 с диагоналями:");
        for (int i = 0; i < array13.length; i++) {
            System.out.print("   ");
            for (int j = 0; j < array13[i].length; j++) {
                System.out.print(array13[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n14. Метод createArray(5, 10):");
        int[] array14 = createArray(5, 10);
        System.out.print("   Результат: ");
        for (int num : array14) {
            System.out.print(num + " ");
        }
    }

    // 1. Метод для печати трех слов в столбец
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2. Метод для проверки знака суммы
    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3. Метод для определения цвета по значению
    public static void printColor() {
        int value = 75;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // 4. Метод для сравнения двух чисел
    public static void compareNumbers() {
        int a = 7;
        int b = 12;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5. Метод для проверки суммы в диапазоне от 10 до 20
    public static boolean checkSumRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // 6. Метод для проверки знака числа
    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("   Число " + number + " положительное");
        } else {
            System.out.println("   Число " + number + " отрицательное");
        }
    }

    // 7. Метод для проверки отрицательности числа
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // 8. Метод для печати строки несколько раз
    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("   " + text);
        }
    }

    // 9. Метод для проверки високосного года
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 10. Метод для инвертирования массива
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    // 11. Метод для заполнения массива числами от 1 до 100
    public static int[] fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // 12. Метод для умножения чисел меньше 6 на 2
    public static void processArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    // 13. Метод для заполнения диагоналей матрицы единицами
    public static int[][] fillDiagonal(int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Главная диагональ: i == j
                // Побочная диагональ: i + j == size - 1
                if (i == j || i + j == size - 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    // 14. Метод для создания массива с одинаковыми значениями
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}