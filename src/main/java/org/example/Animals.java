abstract class Animal {
    String name;
    private static int animalCount = 0;

    Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getCount() {
        return animalCount;
    }

    abstract void run(int distance);
    abstract void swim(int distance);
}

class Dog extends Animal {
    private static int dogCount = 0;

    Dog(String name) {
        super(name);
        dogCount++;
    }

    void run(int d) {
        System.out.println(name + " пробежал " + d + "м");
    }

    void swim(int d) {
        System.out.println(name + " проплыл " + d + "м");
    }

    public static int getCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    boolean full = false;
    private static int catCount = 0;

    Cat(String name) {
        super(name);
        catCount++;
    }

    void run(int d) {
        System.out.println(name + " пробежал " + d + "м");
    }

    void swim(int d) {
        System.out.println(name + " не плавает");
    }

    void eat(Bowl b, int food) {
        if (b.takeFood(food)) full = true;
    }

    public static int getCount() {
        return catCount;
    }
}

class Bowl {
    int food;
    Bowl(int food) { this.food = food; }
    boolean takeFood(int amount) {
        if (amount <= food) {
            food -= amount;
            return true;
        }
        return false;
    }
}

// Главный класс для запуска
public class Animals {
    public static void main(String[] args) {
        Dog dog = new Dog("Курама");
        Cat cat = new Cat("Феликс");

        dog.run(300);
        cat.run(150);
        cat.swim(5);

        Bowl bowl = new Bowl(10);
        Cat[] cats = {new Cat("Снежок"), new Cat("Пётр")};

        for (Cat c : cats) c.eat(bowl, 6);
        for (Cat c : cats) System.out.println(c.name + ": " + (c.full ? "сыт" : "голоден"));

        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Собак: " + Dog.getCount());
        System.out.println("Котов: " + Cat.getCount());
    }
}