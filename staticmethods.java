### **Static Methods in Java**

In Java, a `static` method belongs to the **class** rather than any specific instance of the class. It can be called without creating an object of the class, making it a key feature for utility or helper methods and scenarios where no instance-specific data is required.

---

### **Key Characteristics of Static Methods**
1. **Class-Level Scope**: A static method is associated with the class and not tied to any particular object.
2. **No Instance Variables**: Static methods cannot directly access instance variables or instance methods of the class. They can only work with:
   - Static variables.
   - Other static methods.
   - Parameters passed to them.
3. **Direct Access**: Static methods can be accessed using the class name directly.
4. **Cannot Use `this` or `super`**: Since they are not associated with any instance, they do not have a `this` or `super` reference.

---

### **Declaring a Static Method**

A static method is defined using the `static` keyword:

```java
class Example {
    static void displayMessage() {
        System.out.println("This is a static method.");
    }
}
```

You can call this method using the class name:
```java
Example.displayMessage();
```

---

### **When to Use Static Methods**
- To perform operations that do not require data from an instance of the class.
- Utility methods such as `Math.pow()`, `Math.sqrt()`, etc.
- Factory methods that return new objects.

---

### **Example: Static Methods in a Utility Class**

```java
class Calculator {
    // Static method for addition
    static int add(int a, int b) {
        return a + b;
    }

    // Static method for multiplication
    static int multiply(int a, int b) {
        return a * b;
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        // Call static methods directly using the class name
        int sum = Calculator.add(5, 10);
        int product = Calculator.multiply(5, 10);

        System.out.println("Sum: " + sum);         // Output: Sum: 15
        System.out.println("Product: " + product); // Output: Product: 50
    }
}
```

---

### **Static Methods vs Instance Methods**

| Feature              | Static Method                              | Instance Method                           |
|----------------------|--------------------------------------------|-------------------------------------------|
| **Belongs To**        | Class                                      | Object                                    |
| **Access**            | Called using class name or object         | Called only through an object             |
| **Works On**          | Only static variables or passed parameters | Instance variables and methods            |
| **Memory Usage**      | Single memory allocation for the method    | Separate for each instance                |
| **Example**           | Utility methods (e.g., `Math.pow()`)       | Object-specific methods (e.g., getters)   |

---

### **Static Method with Static and Instance Members**

```java
class Mobile {
    static String type = "Smartphone"; // Static variable
    String brand;                     // Instance variable

    // Static method
    static void displayType() {
        System.out.println("Mobile Type: " + type);
        // Cannot access 'brand' directly because it is an instance variable
        // System.out.println(brand); // This would cause a compilation error
    }

    // Instance method
    void displayDetails() {
        System.out.println("Brand: " + brand + ", Type: " + type);
    }
}

public class StaticMethodExample2 {
    public static void main(String[] args) {
        // Access the static method without creating an object
        Mobile.displayType();

        // Create an object to access instance variables and methods
        Mobile m1 = new Mobile();
        m1.brand = "Samsung";
        m1.displayDetails();
    }
}
```

---

### **Output**

```
Mobile Type: Smartphone
Brand: Samsung, Type: Smartphone
```

---

### **Points to Remember**
1. **Cannot Access Non-Static Members**: Static methods cannot access instance variables or call instance methods directly.
   - Workaround: Pass the object of the class as a parameter if needed.
2. **Direct Access to Static Members**: Static methods can directly access other static variables and methods.
3. **No `this` or `super` Keyword**: Static methods cannot use these references since they are not tied to any instance.

---

### **Use Cases of Static Methods**
1. **Utility Functions**:
   - `Math.pow()`, `Math.sqrt()`, etc.
2. **Factory Methods**:
   - Methods that return new objects.
3. **Global Counters or Trackers**:
   - Methods for manipulating global counters.

---

### **Advanced Example: Static and Instance Collaboration**

```java
class Library {
    static int totalBooks = 100; // Static variable
    int borrowedBooks;           // Instance variable

    // Static method to display total books
    static void displayTotalBooks() {
        System.out.println("Total Books in Library: " + totalBooks);
    }

    // Instance method to borrow a book
    void borrowBook() {
        if (totalBooks > 0) {
            totalBooks--;
            borrowedBooks++;
            System.out.println("Book borrowed! Remaining books: " + totalBooks);
        } else {
            System.out.println("No books left to borrow.");
        }
    }
}

public class StaticMethodExample3 {
    public static void main(String[] args) {
        // Access static method
        Library.displayTotalBooks();

        // Create objects for library members
        Library member1 = new Library();
        Library member2 = new Library();

        // Borrow books using instance methods
        member1.borrowBook();
        member2.borrowBook();

        // Display total books again using static method
        Library.displayTotalBooks();
    }
}
```

---

### **Output**

```
Total Books in Library: 100
Book borrowed! Remaining books: 99
Book borrowed! Remaining books: 98
Total Books in Library: 98
```

---

### **Conclusion**
Static methods in Java are essential for class-level functionality that does not depend on object states. They provide a clean and efficient way to perform utility operations, manage shared data, or create factory-like behaviors.


  ### **Example: Static Methods Cannot Directly Access Non-Static Methods**

A `static` method is not tied to any specific object, meaning it cannot directly access non-static methods or instance variables. Non-static methods require an instance of the class to be called because they depend on the object's state.

---

### **Code Example**

```java
class Example {
    int instanceVariable = 10; // Non-static (instance) variable

    // Non-static (instance) method
    void displayInstanceMethod() {
        System.out.println("This is a non-static method.");
        System.out.println("Instance Variable: " + instanceVariable);
    }

    // Static method
    static void displayStaticMethod() {
        System.out.println("This is a static method.");

        // Trying to access a non-static method directly
        // displayInstanceMethod(); // Compilation error: non-static method cannot be referenced from a static context

        // Trying to access a non-static variable directly
        // System.out.println(instanceVariable); // Compilation error: non-static variable cannot be referenced from a static context
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        // Calling the static method
        Example.displayStaticMethod();

        // Calling the non-static method through an object
        Example obj = new Example();
        obj.displayInstanceMethod();
    }
}
```

---

### **Output**

```
This is a static method.
This is a non-static method.
Instance Variable: 10
```

---

### **Explanation**

1. **Static Method Restrictions**:
   - In the static method `displayStaticMethod()`, we attempted to call the instance method `displayInstanceMethod()` and access the instance variable `instanceVariable` directly.
   - Both resulted in **compilation errors** because `static` methods do not have access to non-static members.

2. **Solution**:
   - To access non-static members, a `static` method must create an **object** of the class and use that object to call the non-static method or access the non-static variable.

---

### **Corrected Code to Access Non-Static Members via Object**

```java
class Example {
    int instanceVariable = 10;

    void displayInstanceMethod() {
        System.out.println("This is a non-static method.");
        System.out.println("Instance Variable: " + instanceVariable);
    }

    static void displayStaticMethod() {
        System.out.println("This is a static method.");

        // Create an object to access non-static members
        Example obj = new Example();
        obj.displayInstanceMethod(); // Access non-static method
        System.out.println("Instance Variable via object: " + obj.instanceVariable);
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        Example.displayStaticMethod();
    }
}
```

---

### **Output**

```
This is a static method.
This is a non-static method.
Instance Variable: 10
Instance Variable via object: 10
```

---

### **Key Takeaways**
1. **Direct Access**:
   - `static` methods can only directly access other static members.
   - Non-static methods and variables are tied to an instance and cannot be accessed without an object.

2. **Workaround**:
   - To access non-static members, create an instance of the class within the static method.

3. **Best Practice**:
   - Use `static` methods for functionality that does not depend on the state of any object.
   - Keep instance-specific logic within non-static methods.
