// Abstract class Animal, representing general properties and behaviors of animals.
abstract class Animal {
    String name;
    int age;
    String species; // Corrected from "spices" to "species"

    // Abstract method sound to be implemented by subclasses.
    abstract void sound();

    // Constructor for Animal class
    Animal() {
        System.out.println("Animal is created");
    }

    // Public method to represent sleeping behavior, accessible to subclasses.
    public void sleep() {
        System.out.println("Sleeping");
    }
}

// Interface Carnivorous, representing behavior of carnivorous animals.
interface Carnivorous {
    // Method to define eating behavior of carnivorous animals
    void eat();
}

// Dog class extends Animal and implements Carnivorous to specify it as a
// carnivorous animal.
class Dog extends Animal implements Carnivorous {
    Dog() {
        System.out.println("Dog is created");
    }

    // Implementing the sound method from Animal.
    public void sound() {
        System.out.println("Bark");
    }

    // Implementing the eat method from Carnivorous interface.
    public void eat() {
        System.out.println("Dog is eating meat");
    }
}

// Cat class extending Animal, representing a specific type of animal.
class Cat extends Animal {
    public void sound() {
        System.out.println("Meow");
    }
}

// Main class containing the main method
public class Animals {
    public static void main(String[] args) {
        // Creating a Dog object, which calls Animal and Dog constructors.
        Dog dog = new Dog();
        dog.sound(); // Calls Dog's implementation of sound
        dog.eat(); // Calls Dog's implementation of eat from Carnivorous
        dog.sleep(); // Calls sleep from Animal class

        // Creating a Cat object, which calls the Animal constructor.
        Cat cat = new Cat();
        cat.sound(); // Calls Cat's implementation of sound
        cat.sleep(); // Calls sleep from Animal class
    }
}
