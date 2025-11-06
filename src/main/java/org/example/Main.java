public class Main {
    public static void main(String[] args) {
        // Задание 1: Животные
        Dog dog = new Dog("Курама");
        Cat cat = new Cat("Феликс");

        dog.run(300);
        cat.run(150);
        cat.swim(5);

        Bowl bowl = new Bowl(10);
        Cat[] cats = {new Cat("Снежок"), new Cat("Пётр")};

        for (Cat c : cats) c.eat(bowl, 6);
        for (Cat c : cats) System.out.println(c.name + ": " + (c.full ? "сыт" : "голоден"));

        // Задание 2: Фигуры
        Figure circle = new Circle(5, "Зеленый", "Желтый");
        Figure rect = new Rectangle(4, 6, "Оранжевый", "Серый");

        circle.print();
        rect.print();
    }
}

// Задание 1
class Animal {
    String name;
    Animal(String name) { this.name = name; }
}

class Dog extends Animal {
    Dog(String name) { super(name); }
    void run(int d) { System.out.println(name + " пробежал " + d + "м"); }
    void swim(int d) { System.out.println(name + " проплыл " + d + "м"); }
}

class Cat extends Animal {
    boolean full = false;
    Cat(String name) { super(name); }
    void run(int d) { System.out.println(name + " пробежал " + d + "м"); }
    void swim(int d) { System.out.println(name + " не плавает"); }
    void eat(Bowl b, int food) { if (b.takeFood(food)) full = true; }
}

class Bowl {
    int food;
    Bowl(int food) { this.food = food; }
    boolean takeFood(int amount) {
        if (amount <= food) { food -= amount; return true; }
        return false;
    }
}

// Задание 2
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
    double r; String f, b;
    Circle(double r, String f, String b) { this.r = r; this.f = f; this.b = b; }
    public double area() { return Math.PI * r * r; }
    public double perimeter() { return 2 * Math.PI * r; }
    public String fill() { return f; }
    public String border() { return b; }
}

class Rectangle implements Figure {
    double w, h; String f, b;
    Rectangle(double w, double h, String f, String b) { this.w = w; this.h = h; this.f = f; this.b = b; }
    public double area() { return w * h; }
    public double perimeter() { return 2 * (w + h); }
    public String fill() { return f; }
    public String border() { return b; }
}