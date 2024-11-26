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

### **Documentation: Static Block with Constructor in Java**

Static blocks and constructors are both used to initialize values, but they differ significantly in their purpose and behavior. Let’s explore how they work together.

---

### **Key Differences: Static Block vs Constructor**

| **Feature**               | **Static Block**                                   | **Constructor**                           |
|---------------------------|---------------------------------------------------|-------------------------------------------|
| **When Executed**          | Runs once when the class is loaded into memory.   | Runs each time an object of the class is created. |
| **Scope**                  | Used for initializing **static variables** or running one-time logic. | Used for initializing **instance variables** for each object. |
| **Invocation**             | Automatically invoked by JVM when the class is loaded. | Called when an object is created using the `new` keyword. |
| **Parameters**             | Cannot accept parameters.                         | Can accept parameters to initialize specific values. |
| **Frequency**              | Executes only once.                               | Executes every time a new object is created. |

---

### **Example: Static Block with Constructor**

```java
class Example {
    static String staticVariable; // Static variable
    int instanceVariable;         // Instance variable

    // Static block
    static {
        System.out.println("Static block executed.");
        staticVariable = "Initialized in static block";
    }

    // Constructor
    Example(int value) {
        System.out.println("Constructor executed.");
        this.instanceVariable = value;
    }

    // Method to display instance and static variables
    void display() {
        System.out.println("Static Variable: " + staticVariable);
        System.out.println("Instance Variable: " + instanceVariable);
    }
}

public class StaticBlockConstructorDemo {
    public static void main(String[] args) {
        System.out.println("Main method starts.");

        // Creating the first object
        Example obj1 = new Example(100);
        obj1.display();

        // Creating the second object
        Example obj2 = new Example(200);
        obj2.display();
    }
}
```

---

### **Output**

```
Static block executed.
Main method starts.
Constructor executed.
Static Variable: Initialized in static block
Instance Variable: 100
Constructor executed.
Static Variable: Initialized in static block
Instance Variable: 200
```

---

### **Explanation**

1. **Static Block Execution**:
   - The static block runs **only once** when the `Example` class is loaded.
   - It initializes the static variable `staticVariable`.

2. **Constructor Execution**:
   - The constructor runs **every time** an object is created.
   - It initializes the instance variable `instanceVariable` with the value passed to it.

3. **Display Method**:
   - The `display()` method demonstrates how static and instance variables can be accessed.

---

### **Key Observations**
1. **Static Initialization**:
   - Static blocks are useful for setting up shared resources or initializing static variables with complex logic.

2. **Instance Initialization**:
   - Constructors are used for instance-specific initialization and allow passing parameters.

3. **Execution Order**:
   - Static blocks execute before the `main()` method or any constructor.
   - Constructors execute only when objects are created.

---

### **Use Case: Combining Static Block and Constructor**

Let’s see a real-world use case where both are used:

```java
class Database {
    static String dbType;  // Static variable to hold database type
    String dbName;         // Instance variable for specific database name

    // Static block to initialize the static variable
    static {
        System.out.println("Loading database configuration...");
        dbType = "Relational Database";
    }

    // Constructor to initialize the instance variable
    Database(String name) {
        System.out.println("Connecting to database...");
        this.dbName = name;
    }

    // Method to display database details
    void displayDetails() {
        System.out.println("Database Type: " + dbType);
        System.out.println("Database Name: " + dbName);
    }
}

public class StaticBlockWithConstructor {
    public static void main(String[] args) {
        System.out.println("Main method starts.");

        // Creating database objects
        Database db1 = new Database("MySQL");
        db1.displayDetails();

        Database db2 = new Database("PostgreSQL");
        db2.displayDetails();
    }
}
```

---

### **Output**

```
Main method starts.
Loading database configuration...
Connecting to database...
Database Type: Relational Database
Database Name: MySQL
Connecting to database...
Database Type: Relational Database
Database Name: PostgreSQL

You can execute a **static block** without creating an object by explicitly referencing the class using the `Class.forName()` method. This triggers the class-loading process, which executes the static block without requiring an object of the class to be created.

Here’s how you can do it:

---

### **Code Example: Trigger Static Block Without Object Creation**

```java
class Example {
    static {
        System.out.println("Static block executed.");
    }

    public static void staticMethod() {
        System.out.println("Static method executed.");
    }
}

public class TriggerStaticBlock {
    public static void main(String[] args) {
        System.out.println("Main method starts.");

        try {
            // Loading the Example class explicitly
            Class.forName("Example");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Main method ends.");
    }
}
```

---

### **Output**

```
Main method starts.
Static block executed.
Main method ends.
```

---

### **Explanation**

1. **Class.forName("Example")**:
   - This explicitly loads the `Example` class into memory, which triggers the static block of the class to execute.
   - No object creation or explicit method calls are required.

2. **Static Block Execution**:
   - The static block executes as soon as the class is loaded.

3. **Flow of Execution**:
   - `Main method starts.` is printed first.
   - The `Class.forName("Example")` call loads the `Example` class, executing its static block.
   - The `Main method ends.` is printed after the static block execution.

---

### **Alternative: Access a Static Variable or Method**

Another way to trigger the static block without creating an object is to access a static variable or method from the class.

```java
public class TriggerStaticBlock {
    public static void main(String[] args) {
        System.out.println("Main method starts.");

        // Access a static method or variable
        Example.staticMethod();

        System.out.println("Main method ends.");
    }
}
```

**Output:**
```
Main method starts.
Static block executed.
Static method executed.
Main method ends.
```

Here, the static block is executed when the class is loaded because the `staticMethod()` is referenced.

---

### **Key Takeaways**
- Use `Class.forName("ClassName")` to explicitly load the class into memory and execute its static block without creating an object.
- Accessing a static method or variable will also trigger the static block because the class must be loaded to access its static members.
