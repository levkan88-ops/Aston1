package org.example;

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