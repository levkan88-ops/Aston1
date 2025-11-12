package org.example;

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
