/**
 * This class represents a Pen with attributes such as color, type, and length.
 * It provides methods to write and refill the pen.
 */
class pen {
    String color;
    String type; // ball, gel
    int length;

    /**
     * This method simulates writing with the pen.
     */
    public void write() {
        System.out.println("Writing...");
    }

    /**
     * This method simulates refilling the pen and prints its attributes.
     */
    public void refill() {
        System.out.println("Refilling...");
        System.out.println(this.color + " Color " + this.type + " In Type For Length " + this.length);
    }
}

/**
 * This class represents a Student with attributes such as name, roll number,
 * and branch.
 * It provides methods for studying and attending lectures.
 */
class Student {
    String name;
    int rollNo;
    String branch;

    /**
     * This method simulates the student studying.
     */
    public void study() {
        System.out.println("Studying...");
    }

    /**
     * This method simulates the student attending a lecture.
     */
    public void attendLecture() {
        System.out.println("Attending Lecture...");
    }

    /**
     * Constructor to initialize a Student object with specified name, roll number,
     * and branch.
     * 
     * @param name   the name of the student
     * @param rollNo the roll number of the student
     * @param branch the branch of the student
     */
    Student(String name, int rollNo, String branch) {
        System.out.println("Student Constructor Called");
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
        System.out.println(name);
    }

    /**
     * Default constructor to initialize a Student object.
     */
    Student() {
        System.out.println("Student Constructor Called");
    }

    /**
     * Copy constructor to initialize a Student object with another Student object.
     * 
     * @param s the student object to copy
     */
    Student(Student s) {
        System.out.println("Student Constructor Called");
        this.name = s.name;
        this.rollNo = s.rollNo;
        this.branch = s.branch;
        System.out.println(name + " " + rollNo + " " + branch);
    }
}

/**
 * The main class to demonstrate the usage of Pen and Student classes.
 * It creates instances of Pen and Student, and calls their methods.
 * 
 * Polymorphism in Java:
 * Polymorphism is the ability of an object to take on many forms. It allows one
 * interface to be used for a general class of actions.
 * The specific action is determined by the exact nature of the situation.
 * 
 * Notes on Java OOPs Concepts:
 * - Encapsulation: Wrapping data (variables) and code (methods) together as a
 * single unit.
 * - Inheritance: Mechanism where one class acquires the properties and
 * behaviors of a parent class.
 * - Polymorphism: Ability of a variable, function, or object to take on
 * multiple forms.
 * - Abstraction: Hiding the internal implementation details and showing only
 * the functionality to the users.
 * - Java does not support multiple inheritance directly to avoid complexity and
 * simplify the design.
 * - Java has no pointers, no destructors, and relies on garbage collection to
 * manage memory.
 */
public class Pens {
    public static void main(String[] args) {
        pen p1 = new pen();
        p1.color = "Blue"; // use . to access the properties of the object
        p1.type = "Ball";
        p1.length = 5;
        p1.write();
        p1.refill();

        Student s1 = new Student();
        s1.name = "Kelvin";
        s1.rollNo = 2448501;
        s1.branch = "AI ML";
        s1.study();
        s1.attendLecture();

        Student s2 = new Student(s1);
        System.out.println(s2.branch);
    }
}
