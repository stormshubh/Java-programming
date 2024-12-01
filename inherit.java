### **Java Inheritance Documentation**

---

#### **What is Inheritance?**

**Inheritance** is a mechanism in Java where one class (child or subclass) acquires the properties and methods of another class (parent or superclass). It promotes **code reuse** and establishes a relationship between classes.

---

### **Key Features of Inheritance**

1. **Code Reusability**:
   - Subclasses can reuse the fields and methods of the parent class, reducing redundancy.

2. **Parent-Child Relationship**:
   - The subclass inherits from the superclass and can have additional properties or methods.

3. **`extends` Keyword**:
   - Used to establish inheritance in Java.

4. **Overriding**:
   - Subclasses can provide their own implementation of methods from the parent class.

5. **Types of Inheritance in Java**:
   - **Single Inheritance**: A class inherits from one parent class.
   - **Multilevel Inheritance**: A class inherits from a class that is already a subclass.
   - **Hierarchical Inheritance**: Multiple subclasses inherit from a single parent class.

6. **`super` Keyword**:
   - Refers to the parent class.
   - Used to call parent class constructors or methods.

7. **Access Modifiers in Inheritance**:
   - **`public`**: Accessible to all classes.
   - **`protected`**: Accessible within the same package and subclasses.
   - **`private`**: Not inherited.
   - **`default`**: Accessible within the same package only.

---

### **Why Use Inheritance?**

1. To promote **code reuse** and avoid duplication.
2. To support the concept of hierarchical classification in object-oriented design.
3. To allow for **method overriding** and **polymorphism**.

---

### **Examples of Inheritance**

#### **1. Single Inheritance**
```java
// Parent Class
class Calculator {
    // Method for addition
    public int add(int a, int b) {
        return a + b;
    }

    // Method for subtraction
    public int subtract(int a, int b) {
        return a - b;
    }
}

// Child Class
class AdvancedCalculator extends Calculator {
    // Additional method for multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

    // Additional method for division
    public double divide(int a, int b) {
        if (b != 0) {
            return (double) a / b;
        } else {
            System.out.println("Division by zero is not allowed.");
            return 0.0;
        }
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        // Create an object of the child class
        AdvancedCalculator advCalc = new AdvancedCalculator();

        // Access methods from the parent class
        System.out.println("Addition: " + advCalc.add(10, 5));
        System.out.println("Subtraction: " + advCalc.subtract(10, 5));

        // Access methods from the child class
        System.out.println("Multiplication: " + advCalc.multiply(10, 5));
        System.out.println("Division: " + advCalc.divide(10, 5));
    }
}
```

**Output:**
```
Addition: 15
Subtraction: 5
Multiplication: 50
Division: 2.0
```

---

#### **2. Multilevel Inheritance**
```java
// Parent Class
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

// Intermediate Class (Child of Calculator)
class AdvancedCalculator extends Calculator {
    public int multiply(int a, int b) {
        return a * b;
    }
}

// Further Child Class
class ScientificCalculator extends AdvancedCalculator {
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        ScientificCalculator sciCalc = new ScientificCalculator();

        // Access methods from all levels
        System.out.println("Addition: " + sciCalc.add(10, 5));
        System.out.println("Multiplication: " + sciCalc.multiply(10, 5));
        System.out.println("Power: " + sciCalc.power(2, 3));
    }
}
```

**Output:**
```
Addition: 15
Multiplication: 50
Power: 8.0
```

---

#### **3. Using `super` Keyword**
```java
// Parent Class
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

// Child Class
class AdvancedCalculator extends Calculator {
    // Overriding the add method
    @Override
    public int add(int a, int b) {
        System.out.println("Using overridden add method.");
        return super.add(a, b) + 1; // Call parent class's add method and add 1
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        AdvancedCalculator advCalc = new AdvancedCalculator();
        System.out.println("Addition with AdvancedCalculator: " + advCalc.add(10, 5));
    }
}
```

**Output:**
```
Using overridden add method.
Addition with AdvancedCalculator: 16

#### **super and this methods**
// Parent Class (A)
class A {
    // Default Constructor of A
    public A() {
        System.out.println("Default Constructor of Class A");
    }

    // Parameterized Constructor of A
    public A(String message) {
        System.out.println("Parameterized Constructor of Class A: " + message);
    }
}

// Child Class (B)
class B extends A {
    // Default Constructor of B
    public B() {
        this("Hello from Class B"); // Call parameterized constructor of B
        System.out.println("Default Constructor of Class B");
    }

    // Parameterized Constructor of B
    public B(String message) {
        super("Hello from Class A"); // Call parameterized constructor of A
        System.out.println("Parameterized Constructor of Class B: " + message);
    }
}

// Main Class
public class ThisSuperDemo {
    public static void main(String[] args) {
        // Create an object of Class B
        B obj = new B(); // Automatically triggers the constructor chain
    }
}

#### Output
Parameterized Constructor of Class A: Hello from Class A
Parameterized Constructor of Class B: Hello from Class B
Default Constructor of Class B

  
// Parent Class (A)
class A {
    String message;

    // Constructor of A
    public A(String msg) {
        this.message = msg; // Use 'this' to refer to the current class field
        System.out.println("Inside A's Constructor: " + this.message);
    }

    // Method in A
    public void displayMessage() {
        System.out.println("Message from Class A: " + message);
    }
}

// Child Class (B)
class B extends A {
    String message;

    // Constructor of B
    public B(String parentMsg, String childMsg) {
        super(parentMsg); // Call the constructor of the parent class
        this.message = childMsg; // Initialize child class field
        System.out.println("Inside B's Constructor: " + this.message);
    }

    // Method in B
    public void displayMessage() {
        super.displayMessage(); // Call the parent class method
        System.out.println("Message from Class B: " + this.message);
    }

    // Method to demonstrate 'this'
    public void show() {
        System.out.println("Calling show() method from B:");
        this.displayMessage(); // Call current class's displayMessage
    }
}

// Main Class
public class ThisSuperDemo {
    public static void main(String[] args) {
        // Create an object of Class B
        B obj = new B("Hello from A", "Hello from B");

        // Call methods to demonstrate 'this' and 'super'
        obj.displayMessage(); // Calls overridden method in B
        obj.show();           // Calls current class's method using 'this'
    }
}


### Output
Inside A's Constructor: Hello from A
Inside B's Constructor: Hello from B
Message from Class A: Hello from A
Message from Class B: Hello from B
Calling show() method from B:
Message from Class A: Hello from A
Message from Class B: Hello from B


The distinction between using `message` in Class `A` and `this.message` in Class `B` lies in **clarity** and **the need to differentiate between variables with the same name in the child class (`B`)**.

Let’s break this down:

---

### **Class `A`:**
```java
public void displayMessage() {
    System.out.println("Message from Class A: " + message);
}
```
- In Class `A`, there is no ambiguity because `message` directly refers to the instance variable `message` of Class `A`. 
- Since there is no local variable or parameter named `message` in this method, Java knows that `message` refers to the class-level variable.
- Using `this.message` here is optional but not necessary.

---

### **Class `B`:**
```java
public void displayMessage() {
    super.displayMessage(); // Calls the parent class method
    System.out.println("Message from Class B: " + this.message);
}
```

In Class `B`, **the situation is different because `message` is declared in both `A` and `B`.**

1. **`super.message`** (inherited from Class `A`):
   - Refers to the instance variable `message` of the parent class `A`.

2. **`this.message`** (in Class `B`):
   - Refers to the instance variable `message` declared in the child class `B`.

By explicitly using `this.message`, we ensure that we are referring to the child class's `message` variable. If you simply use `message` in Class `B`, it would still refer to the child class's variable because of scope resolution, but **using `this.message` improves clarity** in the code.

---

### **Why Does Class `B` Need `this.message`?**

- **Avoid ambiguity:** Since both `A` and `B` have a variable named `message`, explicitly using `this.message` makes it clear that you’re referring to the child class’s `message`.
- **Code readability:** It helps future developers (or yourself) understand the intent of the code, especially when both parent and child classes have similar variable names.

---

### **What Happens If `this` Is Not Used in Class `B`?**

If you remove `this` in Class `B`, the variable `message` still refers to the instance variable of Class `B` because:
1. Class `B`'s own variable shadows the `message` variable of Class `A`.
2. Java will prioritize the most local scope (Class `B`) for `message`.

The code will still work, but it may be less readable or clear in contexts where both parent and child classes share the same field name.





### **Java Method Overriding Documentation**

---

### **What is Method Overriding?**

**Method Overriding** in Java allows a subclass to provide a specific implementation of a method that is already defined in its parent class. It is used to achieve **runtime polymorphism**.

---

### **Key Features of Method Overriding**

1. **Inheritance is Required**:
   - Overriding occurs only in a subclass that inherits from a parent class.

2. **Same Signature**:
   - The overriding method must have the same name, return type, and parameters as the method in the parent class.

3. **Annotation (`@Override`)**:
   - It is good practice to use the `@Override` annotation to ensure the method correctly overrides a parent class method.

4. **Access Modifier**:
   - The overriding method cannot have a more restrictive access modifier than the method in the parent class.
     - For example, if the parent method is `protected`, the child method cannot be `private`.

5. **Cannot Override `final` Methods**:
   - Methods marked `final` in the parent class cannot be overridden.

6. **`super` Keyword**:
   - Used to call the parent class’s overridden method from the subclass.

---

### **Why Use Method Overriding?**

- To provide a specific implementation of a method for a subclass.
- To achieve **runtime polymorphism** (different behavior for the same method).
- To improve flexibility and extensibility of the code.

---

### **Calculator Example of Method Overriding**

#### **Code Implementation**

```java
// Parent Class: Calculator
class Calculator {
    // Method for addition
    public int calculate(int a, int b) {
        System.out.println("Performing addition in Calculator");
        return a + b;
    }
}

// Subclass: AdvancedCalculator
class AdvancedCalculator extends Calculator {
    // Overriding the calculate method
    @Override
    public int calculate(int a, int b) {
        System.out.println("Performing multiplication in AdvancedCalculator");
        return a * b;
    }
}

// Subclass: ScientificCalculator
class ScientificCalculator extends Calculator {
    // Overriding the calculate method
    @Override
    public int calculate(int a, int b) {
        System.out.println("Performing power calculation in ScientificCalculator");
        return (int) Math.pow(a, b);
    }
}

// Main Class
public class MethodOverridingDemo {
    public static void main(String[] args) {
        // Parent class object
        Calculator basicCalc = new Calculator();
        System.out.println("Result (Basic Calculator): " + basicCalc.calculate(5, 3));

        // Subclass object (AdvancedCalculator)
        Calculator advCalc = new AdvancedCalculator();
        System.out.println("Result (Advanced Calculator): " + advCalc.calculate(5, 3));

        // Subclass object (ScientificCalculator)
        Calculator sciCalc = new ScientificCalculator();
        System.out.println("Result (Scientific Calculator): " + sciCalc.calculate(2, 3));
    }
}
```

---

#### **Explanation**

1. **`calculate` Method in Parent Class (`Calculator`)**:
   - Performs basic addition.

2. **Overriding in `AdvancedCalculator`**:
   - The `calculate` method is overridden to perform multiplication instead.

3. **Overriding in `ScientificCalculator`**:
   - The `calculate` method is overridden to compute the power of two numbers.

4. **Polymorphism**:
   - The `calculate` method behaves differently depending on the object type (`basicCalc`, `advCalc`, or `sciCalc`).

---

#### **Output**
```
Performing addition in Calculator
Result (Basic Calculator): 8
Performing multiplication in AdvancedCalculator
Result (Advanced Calculator): 15
Performing power calculation in ScientificCalculator
Result (Scientific Calculator): 8
```

---

### **Key Points of the Example**

1. **`@Override` Annotation**:
   - Ensures that the method in the child class correctly overrides a method in the parent class.

2. **Dynamic Method Dispatch**:
   - When a parent class reference holds a child class object, the method called is determined at runtime based on the actual object type.

3. **Reusability and Extensibility**:
   - Each subclass can implement its specific behavior for the `calculate` method while still using the parent class structure.

---

### **Conclusion**

Method overriding is a fundamental concept in Java that allows flexibility and dynamic behavior in object-oriented programming. By leveraging inheritance and overriding, you can create robust and extensible class hierarchies.
