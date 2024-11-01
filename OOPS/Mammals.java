/**
 * The Animals class serves as a base class for demonstrating inheritance in
 * Java.
 * Inheritance is a fundamental concept in object-oriented programming (OOP)
 * that allows
 * a class to inherit properties and behaviors (methods) from another class.
 * 
 * There are different types of inheritance in Java:
 * 
 * 1. Single Inheritance: A class inherits from one superclass.
 * Example:
 * class Dog extends Animals {
 * // Dog inherits properties and methods from Animals
 * }
 * 
 * 2. Multilevel Inheritance: A class inherits from a superclass, and another
 * class inherits from that subclass.
 * Example:
 * class Mammal extends Animals {
 * // Mammal inherits from Animals
 * }
 * class Dog extends Mammal {
 * // Dog inherits from Mammal, which in turn inherits from Animals
 * }
 * 
 * 3. Hierarchical Inheritance: Multiple classes inherit from a single
 * superclass.
 * Example:
 * class Dog extends Animals {
 * // Dog inherits from Animals
 * }
 * class Cat extends Animals {
 * // Cat inherits from Animals
 * }
 * 
 * 4. Multiple Inheritance (through interfaces): A class can implement multiple
 * interfaces.
 * Note: Java does not support multiple inheritance with classes to avoid
 * complexity and ambiguity.
 * Example:
 * interface Canine {
 * // Interface methods
 * }
 * interface Pet {
 * // Interface methods
 * }
 * class Dog extends Animals implements Canine, Pet {
 * // Dog inherits from Animals and implements Canine and Pet interfaces
 * }
 * 
 * Inheritance allows for code reusability, method overriding, and establishing
 * a natural hierarchy
 * between classes. It is a key feature that promotes the design of more modular
 * and maintainable code.
 */
// Base class
class Animals {
    public void eat() {
        System.out.println("I can eat.");
    }
}

class Mammal extends Animals {
    public void display() {
        System.out.println("I am a mammal.");
    }
}

class Dog extends Mammal {
    public void bark() {
        System.out.println("I am a dog and I bark.");
    }
}

public class Mammals {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.display();
        dog.bark();
    }
}