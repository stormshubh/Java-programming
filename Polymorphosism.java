
Java Polymorphism

Polymorphism is one of the four fundamental principles of Object-Oriented Programming (OOP) in Java, alongside Encapsulation, Inheritance, and Abstraction. The term Polymorphism means "many forms," and in Java, it allows a single entity (such as a method or an object) to take on multiple forms.


---

Types of Polymorphism in Java

1. Compile-Time Polymorphism (Method Overloading)

Occurs when two or more methods in the same class share the same name but differ in:

Number of parameters.

Data type of parameters.

Order of parameters.


Resolved at compile-time by the Java compiler.


Example:

class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two double values
    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Addition of two integers: " + calc.add(5, 10));
        System.out.println("Addition of three integers: " + calc.add(5, 10, 15));
        System.out.println("Addition of two doubles: " + calc.add(5.5, 10.5));
    }
}

Output:

Addition of two integers: 15
Addition of three integers: 30
Addition of two doubles: 16.0




---

2. Runtime Polymorphism (Method Overriding)

Occurs when a subclass provides its specific implementation for a method that is already defined in its parent class.

Resolved at runtime using dynamic method dispatch.

Enables Java to decide at runtime which method implementation to invoke based on the actual object.


Example:

class Animal {
    // Method to be overridden
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal;

        myAnimal = new Dog();
        myAnimal.sound(); // Output: Dog barks

        myAnimal = new Cat();
        myAnimal.sound(); // Output: Cat meows
    }
}




---

Key Differences Between Compile-Time and Runtime Polymorphism


---

Polymorphism in Action

Using Polymorphism with References

Polymorphism is often used when a parent class reference is used to refer to a child class object. This allows for dynamic method dispatch, where the method called depends on the object's type.

Example:

class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape;

        shape = new Circle();
        shape.draw(); // Output: Drawing a circle

        shape = new Rectangle();
        shape.draw(); // Output: Drawing a rectangle
    }
}


---


-----+-++-----+----+++------------
Let's break this down to understand why overloading is compile-time and overriding is runtime.


---

1. Method Overloading (Compile-Time Polymorphism)

What happens in overloading?

In method overloading, the method name is the same, but the parameters (number, type, or order) are different.

When the code is compiled, the Java compiler resolves which method to call by checking:

The method name.

The parameters passed (number and types).


This decision is made entirely during the compilation phase, so it’s called compile-time polymorphism or static binding.



---

Example of Overloading

class Calculator {
    public int add(int a, int b) { // Method 1
        return a + b;
    }

    public double add(double a, double b) { // Method 2
        return a + b;
    }

    public int add(int a, int b, int c) { // Method 3
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));          // Calls Method 1
        System.out.println(calc.add(5.5, 10.5));      // Calls Method 2
        System.out.println(calc.add(5, 10, 15));      // Calls Method 3
    }
}

Why is this Compile-Time?

When the code is compiled, the compiler examines the parameters of the method calls:

For calc.add(5, 10), it finds a match with add(int, int).

For calc.add(5.5, 10.5), it finds a match with add(double, double).

For calc.add(5, 10, 15), it finds a match with add(int, int, int).


The compiler can statically bind the method call to the correct method implementation at compile-time because all the information (method signature and parameters) is available before execution.



---

2. Method Overriding (Runtime Polymorphism)

What happens in overriding?

In method overriding, the method name and parameters are the same in both the parent and child classes, but the method is redefined in the child class.

At runtime, the type of the object (not the reference) determines which version of the method is called.

Since the exact method to call is determined during program execution, it’s called runtime polymorphism or dynamic binding.



---

Example of Overriding

class Animal {
    public void sound() { // Method in the parent class
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() { // Overridden method in the child class
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Parent reference, child object
        myAnimal.sound(); // Which method to call is determined at runtime
    }
}

Why is this Runtime?

In the example, the reference type is Animal, but the actual object type is Dog.

At runtime, Java checks the actual object type (i.e., Dog) to decide which version of the sound() method to call.

This is why the overridden method in the Dog class is executed instead of the Animal class's version.


If it were compile-time, the compiler would only look at the reference type (Animal) and call the Animal class's sound() method, which is not the behavior of overriding.
