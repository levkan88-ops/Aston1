package org.example;

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
