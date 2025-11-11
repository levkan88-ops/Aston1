interface Figure {
    double area();
    double perimeter();
    String fill();
    String border();
    default void print() {
        System.out.printf("P=%.1f S=%.1f Цвет: %s Граница: %s%n", perimeter(), area(), fill(), border());
    }
}

class Circle implements Figure {
    double r;
    String f, b;

    Circle(double r, String f, String b) {
        this.r = r;
        this.f = f;
        this.b = b;
    }

    public double area() {
        return Math.PI * r * r;
    }

    public double perimeter() {
        return 2 * Math.PI * r;
    }

    public String fill() {
        return f;
    }

    public String border() {
        return b;
    }
}

class Rectangle implements Figure {
    double w, h;
    String f, b;

    Rectangle(double w, double h, String f, String b) {
        this.w = w;
        this.h = h;
        this.f = f;
        this.b = b;
    }

    public double area() {
        return w * h;
    }

    public double perimeter() {
        return 2 * (w + h);
    }

    public String fill() {
        return f;
    }

    public String border() {
        return b;
    }
}

class Triangle implements Figure {
    double a, b, c;
    String f, border;

    Triangle(double a, double b, double c, String f, String border) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.border = border;
    }

    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double perimeter() {
        return a + b + c;
    }

    public String fill() {
        return f;
    }

    public String border() {
        return border;
    }
}

// Главный класс для запуска
public class Figures {
    public static void main(String[] args) {
        Figure circle = new Circle(5, "Зеленый", "Желтый");
        Figure rect = new Rectangle(4, 6, "Оранжевый", "Серый");
        Figure triangle = new Triangle(3, 4, 5, "Голубой", "Красный");

        circle.print();
        rect.print();
        triangle.print();
    }
}