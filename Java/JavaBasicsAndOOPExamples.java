// File: JavaBasicsAndOOPExamples.java

// Basic syntax and structure
public class JavaBasicsAndOOPExamples {

    // Entry point of the program
    public static void main(String[] args) {
        // Data types and variables
        int age = 25;
        double height = 5.9;
        char grade = 'A';
        boolean isStudent = true;
        String name = "Ahmed";

        // Displaying values
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Grade: " + grade);
        System.out.println("Is Student: " + isStudent);

        // Operators
        int sum = 10 + 5;
        int difference = 10 - 5;
        int product = 10 * 5;
        int quotient = 10 / 5;
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        // Control Flow Statements
        if (age > 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are not an adult.");
        }

        // Switch statement
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }

        // Loop example
        for (int i = 0; i < 5; i++) {
            System.out.println("Loop iteration: " + i);
        }

        // Function example
        greet(name);

        // Object-Oriented Programming (OOP) Examples
        Person person = new Person("Ahmed ", 30);
        person.introduce();

        Employee employee = new Employee("Amin", 28, "Software Engineer");
        employee.introduce();
        employee.work();
    }

    // Function (Method) example
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Classes and Objects
    static class Person {
        String name;
        int age;

        // Constructor
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method
        void introduce() {
            System.out.println("Hi, I am " + name + " and I am " + age + " years old.");
        }
    }

    // Inheritance, Polymorphism
    static class Employee extends Person {
        String jobTitle;

        // Constructor
        Employee(String name, int age, String jobTitle) {
            super(name, age);
            this.jobTitle = jobTitle;
        }

        // Method Overriding
        @Override
        void introduce() {
            System.out.println("Hi, I am " + name + ", I am " + age + " years old, and I work as a " + jobTitle + ".");
        }

        // Method specific to Employee
        void work() {
            System.out.println("I am working as a " + jobTitle + ".");
        }
    }
}
