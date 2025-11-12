package org.example;

public class Circle implements Figure {
    double r;
    String f;
    String b;

    public Circle(double r, String f, String b) {
        this.r = r;
        this.f = f;
        this.b = b;
    }

    public double area() {
        return Math.PI * this.r * this.r;
    }

    public double perimeter() {
        return (Math.PI * 2D) * this.r;
    }

    public String fill() {
        return this.f;
    }

    public String border() {
        return this.b;
    }
}