### **Java Constructor Documentation**

---

#### **What is a Constructor in Java?**

A **constructor** in Java is a special method that is called automatically when an object of a class is created. It is used to initialize the object and set up its initial state.

---

### **Key Features of Constructors**

1. **Same Name as the Class**:
   - A constructor's name must match the name of the class.
   
2. **No Return Type**:
   - Constructors do not have a return type, not even `void`.

3. **Automatically Called**:
   - The constructor is invoked automatically when an object is created.

4. **Can Be Overloaded**:
   - A class can have multiple constructors with different parameter lists (constructor overloading).

5. **Types of Constructors**:
   - **Default Constructor**: A constructor with no parameters.
   - **Parameterized Constructor**: A constructor with parameters to initialize an object with specific values.

6. **Cannot Be `static`, `final`, or `abstract`**:
   - These modifiers are not applicable to constructors.

---

### **Why Use Constructors?**

- To initialize objects with specific values when they are created.
- To enforce mandatory fields (parameters) during object creation.
- To automate the setup of initial states or resources for the object.

---

### **Constructor Types**

1. **Default Constructor**:
   - Provided automatically by Java if no constructor is defined.
   - Initializes default values for instance variables (e.g., `0` for numbers, `null` for objects).

2. **Parameterized Constructor**:
   - Allows passing arguments during object creation to initialize instance variables with specific values.

---

### **Examples**

#### **1. Default Constructor**
```java
class Car {
    String brand;
    int speed;

    // Default Constructor
    public Car() {
        brand = "Unknown";
        speed = 0;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car = new Car(); // Default constructor is called
        car.displayDetails();
    }
}
```

**Output:**
```
Brand: Unknown
Speed: 0
```

---

#### **2. Parameterized Constructor**
```java
class Car {
    String brand;
    int speed;

    // Parameterized Constructor
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car = new Car("Tesla", 120); // Parameterized constructor is called
        car.displayDetails();
    }
}
```

**Output:**
```
Brand: Tesla
Speed: 120
```

---

#### **3. Constructor Overloading**
```java
class Car {
    String brand;
    int speed;

    // Default Constructor
    public Car() {
        brand = "Unknown";
        speed = 0;
    }

    // Parameterized Constructor
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Constructor with one parameter
    public Car(String brand) {
        this.brand = brand;
        this.speed = 100; // Default speed
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car1 = new Car();                // Default constructor
        Car car2 = new Car("Toyota", 150);   // Parameterized constructor
        Car car3 = new Car("Ford");          // Constructor with one parameter

        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}
```

**Output:**
```
Brand: Unknown
Speed: 0
Brand: Toyota
Speed: 150
Brand: Ford
Speed: 100
```

---

#### **4. Constructor with `this` Keyword**
```java
class Car {
    String brand;
    int speed;

    // Parameterized Constructor
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed; // 'this' refers to the current object
    }

    public void displayDetails() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Speed: " + this.speed);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car = new Car("BMW", 180); // Parameterized constructor
        car.displayDetails();
    }
}
```

---

### **Key Differences Between Constructor and Method**

| Feature              | Constructor                              | Method                               |
|----------------------|------------------------------------------|--------------------------------------|
| **Purpose**          | Initializes an object.                  | Executes specific logic or actions. |
| **Name**             | Must match the class name.              | Can have any valid name.            |
| **Return Type**      | No return type (not even `void`).        | Must have a return type.            |
| **Call**             | Called automatically during object creation. | Must be called explicitly.         |

---

### **Important Notes**

1. **Default Constructor**:
   - If no constructor is defined, Java automatically provides a default constructor.
   - If any constructor (default or parameterized) is defined, the compiler does not create a default constructor.

2. **`this()` for Constructor Chaining**:
   - A constructor can call another constructor in the same class using `this()`.

---

### **Constructor Chaining Example**

```java
class Car {
    String brand;
    int speed;

    // Default Constructor
    public Car() {
        this("Unknown", 0); // Call parameterized constructor
    }

    // Parameterized Constructor
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car = new Car(); // Calls default constructor, which chains to parameterized constructor
        car.displayDetails();
    }
}
```

**Output:**
```
Brand: Unknown
Speed: 0
```

---

### **Conclusion**
Constructors are crucial for initializing objects in Java. They enable the setup of an object’s state during creation, ensure mandatory fields are set, and offer flexibility through overloading and chaining. Proper use of constructors enhances readability, modularity, and maintainability of Java programs.
