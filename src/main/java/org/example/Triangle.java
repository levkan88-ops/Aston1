package org.example;

public class Triangle implements Figure {
    double a;
    double b;
    double c;
    String f;
    String border;

    public Triangle(double a, double b, double c, String f, String border) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.border = border;
    }

    public double area() {
        double p = this.perimeter() / (double)2.0F;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public String fill() {
        return this.f;
    }

    public String border() {
        return this.border;
    }
}