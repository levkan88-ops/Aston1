package org.example;

public class Rectangle implements Figure {
    double w;
    double h;
    String f;
    String b;

    public Rectangle(double w, double h, String f, String b) {
        this.w = w;
        this.h = h;
        this.f = f;
        this.b = b;
    }

    public double area() {
        return this.w * this.h;
    }

    public double perimeter() {
        return (double)2.0F * (this.w + this.h);
    }

    public String fill() {
        return this.f;
    }

    public String border() {
        return this.b;
    }
}

