
// package OOPS;
import java.util.*;
import java.io.*;
import java.lang.*;

class Shape {
    String name;
    String color;
    String type;
    int length;
    int breadth;

    public void draw() {
        System.out.println("Drawing a " + this.name);
    }

    Shape(String name) {
        System.out.println("Shape Constructor Called");
        System.out.println(this.name);
    }

}

class Triangle extends Shape {
    int base;
    int height;
    // this.name="Triangle";

    // public void draw() {
    // System.out.println("Drawing a Triangle");
    // }

    Triangle(int base, int height) {
        super("Triangle");
        this.name = "Triangle";
        System.out.println("Triangle Constructor Called");
        this.base = base;
        this.height = height;
    }

    Triangle() {
        super("Triangle");
        this.name = "Triangle";
        System.out.println("Triangle Constructor Called");
    }
}

public class Shapes {
    public static void main(String[] args) {
        Triangle t = new Triangle(10, 20);
        t.draw();
    }
}