package org.example;

public interface Figure {
    double area();

    double perimeter();

    String fill();

    String border();

    default void print() {
        System.out.printf("P=%.1f S=%.1f Цвет: %s Граница: %s%n", this.perimeter(), this.area(), this.fill(), this.border());
    }
}