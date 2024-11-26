### **Documentation: Static Block in Java**

In Java, a **static block** (also called a static initializer block) is a special block of code that is executed **once** when the class is loaded into memory. It is used to initialize static variables or execute logic that must run only once during the lifetime of the class.

---

### **Key Features of Static Block**
1. **Executed Once**:
   - Static blocks are executed only once when the class is loaded by the JVM.
   - They execute before any `main()` method, constructors, or other methods if in the same class.

2. **No Explicit Call**:
   - The JVM automatically executes the static block; you cannot invoke it explicitly.

3. **Order of Execution**:
   - If a class contains multiple static blocks, they are executed in the order they appear in the code.

4. **Primary Use**:
   - Initializing static variables.
   - Executing one-time setup logic, such as loading configuration or initializing resources.

---

### **Syntax of Static Block**

```java
class Example {
    static {
        // Static block code
        System.out.println("Static block executed.");
    }
}
```

---

### **Example: Static Block for Initialization**

```java
class Example {
    static int staticVariable;

    // Static block
    static {
        System.out.println("Static block executed.");
        staticVariable = 10; // Initializing static variable
    }

    public static void main(String[] args) {
        System.out.println("Main method executed.");
        System.out.println("Static Variable: " + staticVariable);
    }
}
```

---

### **Output**

```
Static block executed.
Main method executed.
Static Variable: 10
```

---

### **Explanation**
1. **Static Block Execution**:
   - The static block runs first, even before the `main()` method.
   - It initializes the `staticVariable` to `10`.

2. **Static Variable Initialization**:
   - Static blocks are ideal for initializing static variables with complex logic that cannot be done in a single statement.

---

### **Multiple Static Blocks**

You can have more than one static block in a class. They are executed in the order they are defined.

```java
class MultipleStaticBlocks {
    static {
        System.out.println("First static block.");
    }

    static {
        System.out.println("Second static block.");
    }

    public static void main(String[] args) {
        System.out.println("Main method executed.");
    }
}
```

---

### **Output**

```
First static block.
Second static block.
Main method executed.
```

---

### **Static Block vs Static Method**

| **Feature**                | **Static Block**                                       | **Static Method**                         |
|----------------------------|-------------------------------------------------------|-------------------------------------------|
| **Execution**               | Automatically executed when the class is loaded.      | Explicitly called using the class name.   |
| **Purpose**                 | For initializing static variables or one-time logic.  | For reusable class-level operations.      |
| **Parameters**              | Cannot take parameters.                              | Can accept parameters.                    |
| **Invocation**              | Executes only once.                                  | Can be invoked multiple times.            |

---

### **Use Cases of Static Block**
1. **Complex Static Variable Initialization**:
   - Initialize static variables that require multiple statements or complex logic.

2. **Loading Configuration or Libraries**:
   - Load configuration files, initialize resources, or set up environment-specific values.

3. **Logging or Debugging**:
   - Perform one-time logging or debugging when the class is loaded.

---

### **Example: Static Block for Configuration**

```java
class ConfigLoader {
    static String config;

    // Static block
    static {
        System.out.println("Loading configuration...");
        config = "Application Config Loaded"; // Simulate loading a configuration
    }

    public static void main(String[] args) {
        System.out.println("Main method starts.");
        System.out.println("Config: " + config);
    }
}
```

---

### **Output**

```
Loading configuration...
Main method starts.
Config: Application Config Loaded
```

---

### **Advanced Example: Static Block with Multiple Classes**

```java
class ClassA {
    static {
        System.out.println("Static block of ClassA executed.");
    }
}

class ClassB {
    static {
        System.out.println("Static block of ClassB executed.");
    }
}

public class StaticBlockExample {
    public static void main(String[] args) {
        System.out.println("Main method starts.");
        ClassA objA = new ClassA(); // Loading ClassA
        ClassB objB = new ClassB(); // Loading ClassB
    }
}
```

---

### **Output**

```
Main method starts.
Static block of ClassA executed.
Static block of ClassB executed.
```

---

### **Key Takeaways**
1. **Executed Before Main**:
   - Static blocks are executed as soon as the class is loaded, even before the `main()` method.

2. **One-Time Logic**:
   - Ideal for initialization logic that must run only once.

3. **Order Matters**:
   - If multiple static blocks are present, they execute in the order they are written.

4. **Avoid Overuse**:
   - While static blocks are powerful, overusing them for unnecessary logic can lead to complex and less-readable code.

---

### **Best Practices**
- Use static blocks only when necessary, such as for initializing static variables or performing class-level setup.
- Keep the logic inside static blocks minimal to maintain clarity and performance.
