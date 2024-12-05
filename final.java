### **`final` Keyword in Java**

The `final` keyword in Java is a modifier used to impose restrictions on **variables**, **methods**, and **classes**. Once something is declared as `final`, it cannot be modified. 

---

### **Uses of `final` Keyword**
1. **Final Variable**: Makes a variable constant.
2. **Final Method**: Prevents method overriding.
3. **Final Class**: Prevents inheritance.

---

### **1. Final Variables**

#### **Definition**
- A `final` variable is a constant and cannot be reassigned after its initial assignment.

#### **Syntax**
```java
final datatype variableName = value;
```

#### **Example**
```java
public class FinalVariableExample {
    public static void main(String[] args) {
        final int AGE = 25;
        System.out.println("Age: " + AGE);

        // AGE = 30; // This will cause a compilation error
    }
}
```

#### **Characteristics**
1. **Must be Initialized**:
   - At the time of declaration, or
   - In a constructor if the variable is an instance variable.
2. **Cannot Change Value**: Once assigned, it cannot be reassigned.

---

### **2. Final Methods**

#### **Definition**
- A `final` method cannot be overridden by a subclass.

#### **Syntax**
```java
final returnType methodName(parameters) {
    // Method body
}
```

#### **Example**
```java
class Parent {
    final void display() {
        System.out.println("This is a final method.");
    }
}

class Child extends Parent {
    // void display() { } // This will cause a compilation error
}

public class FinalMethodExample {
    public static void main(String[] args) {
        Parent obj = new Parent();
        obj.display();
    }
}
```

#### **Use Case**
- When you want to ensure that the logic of a method cannot be altered by subclasses.

---

### **3. Final Classes**

#### **Definition**
- A `final` class cannot be extended by any other class.

#### **Syntax**
```java
final class ClassName {
    // Class body
}
```

#### **Example**
```java
final class FinalClass {
    void display() {
        System.out.println("This is a final class.");
    }
}

// class SubClass extends FinalClass { } // This will cause a compilation error

public class FinalClassExample {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        obj.display();
    }
}
```

#### **Use Case**
- When you want to prevent the class from being extended to protect its implementation.

---

### **4. Final Parameters**

#### **Definition**
- A `final` parameter ensures that the value of the parameter cannot be modified inside the method.

#### **Syntax**
```java
returnType methodName(final datatype parameterName) {
    // Method body
}
```

#### **Example**
```java
public class FinalParameterExample {
    void display(final int number) {
        // number = number + 1; // This will cause a compilation error
        System.out.println("Number: " + number);
    }

    public static void main(String[] args) {
        FinalParameterExample obj = new FinalParameterExample();
        obj.display(10);
    }
}
```

---

### **Final with Reference Variables**

#### **Definition**
- A `final` reference variable means the reference cannot be changed, but the object it refers to can still be modified.

#### **Example**
```java
class FinalReferenceExample {
    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder("Hello");
        
        // Modifying the object is allowed
        sb.append(" World");
        System.out.println(sb);

        // Reassigning the reference is not allowed
        // sb = new StringBuilder("New Object"); // This will cause a compilation error
    }
}
```

---

### **Final with Static**

A `final` static variable is a constant value shared by all objects of the class.

#### **Example**
```java
class FinalStaticExample {
    final static double PI = 3.14159;

    public static void main(String[] args) {
        System.out.println("Value of PI: " + PI);

        // PI = 3.14; // This will cause a compilation error
    }
}
```

---

### **Rules of the `final` Keyword**

| **Type**        | **Behavior**                                                                                   |
|------------------|-----------------------------------------------------------------------------------------------|
| **Variable**     | Value cannot be changed after initialization.                                                |
| **Reference Variable** | Reference cannot be reassigned, but the object can be modified.                             |
| **Method**       | Cannot be overridden in subclasses.                                                          |
| **Class**        | Cannot be extended by other classes.                                                         |
| **Parameter**    | Value cannot be changed within the method body.                                              |

---

### **Key Differences Between `final`, `finally`, and `finalize`**

| **Keyword**    | **Purpose**                                                                                       |
|----------------|---------------------------------------------------------------------------------------------------|
| `final`        | Modifier used for variables, methods, and classes to impose restrictions (constant, no inheritance). |
| `finally`      | A block used in exception handling to execute code regardless of whether an exception occurred.   |
| `finalize`     | A method in the `Object` class called by the garbage collector before an object is destroyed.     |

---

### **Use Cases of `final`**
1. **For Constants**: Use `final` with `static` to define constants.
2. **For Security**: To ensure methods or classes cannot be overridden or extended.
3. **For Immutability**: To create immutable objects (e.g., use `final` fields in conjunction with private setters).

By using the `final` keyword, you enforce immutability and ensure specific parts of your code are secure and predictable.
