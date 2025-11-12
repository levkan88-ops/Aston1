    package org.example;
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