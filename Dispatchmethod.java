Dynamic Method Dispatch in Java

Dynamic Method Dispatch, also known as Runtime Polymorphism, is the process by which a call to an overridden method is resolved at runtime rather than compile-time. It is achieved using method overriding in Java and involves using a parent class reference to refer to a child class object.


---

How Dynamic Method Dispatch Works

1. Inheritance is required: A method must be overridden in a child class to implement dynamic method dispatch.


2. Reference type determines what methods are accessible: The parent class reference can only call methods defined in the parent class (or overridden in the child).


3. Object type determines which method implementation is executed: At runtime, the JVM determines the actual object type and invokes the corresponding overridden method.




---

Example of Dynamic Method Dispatch

Code Example:

class Animal {
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
        Animal animal; // Parent class reference

        // Pointing to a Dog object
        animal = new Dog();
        animal.sound(); // Output: Dog barks

        // Pointing to a Cat object
        animal = new Cat();
        animal.sound(); // Output: Cat meows
    }
}


---

How It Works

1. The reference animal is of type Animal, but the object it points to can be of any subclass (e.g., Dog or Cat).


2. The method to execute is determined by the actual object type (Dog or Cat) at runtime.


3. The overridden method in the child class is executed.




---

Rules for Dynamic Method Dispatch

1. Access Parent Class Methods Only:
A parent reference can only call methods available in the parent class, even if the object is of the child class.

Example:

class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }

    public void sleep() {
        System.out.println("Animal sleeps");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    public void fetch() {
        System.out.println("Dog fetches the ball");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound(); // Output: Dog barks
        animal.sleep(); // Output: Animal sleeps
        // animal.fetch(); // Compile-time error: fetch() not in Animal class
    }
}


2. Final Methods Can't Be Overridden:
Methods marked as final cannot be overridden, so they cannot participate in dynamic method dispatch.


3. Static Methods Are Not Part of Dispatch:
Static methods are resolved at compile-time, so they don’t participate in dynamic method dispatch.




---

Benefits of Dynamic Method Dispatch

1. Polymorphism Implementation:
Enables runtime polymorphism, allowing flexible and dynamic code.


2. Extensibility:
Makes code extensible; new classes can override methods without changing the existing code.


3. Decoupling:
Promotes loose coupling between classes by relying on parent references.




---

Limitations

1. Only Methods, Not Variables:
Dynamic method dispatch applies only to methods. Variables are resolved based on the reference type.

Example:

class Animal {
    public String type = "Generic Animal";
}

class Dog extends Animal {
    public String type = "Dog";
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println(animal.type); // Output: Generic Animal
    }
}

Why?
The variable type is resolved based on the reference type (Animal), not the actual object type (Dog).


2. Performance Overhead:
Resolving method calls at runtime involves a performance overhead compared to compile-time resolution.




---

Conclusion

Dynamic method dispatch is a powerful feature in Java that allows a program to decide at runtime which method implementation to execute. It is central to achieving runtime polymorphism and is key to building flexible and extensible object-oriented systems.

