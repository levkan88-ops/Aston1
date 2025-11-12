package org.example;

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
