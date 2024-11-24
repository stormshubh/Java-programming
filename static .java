// Define the Mobile class
class Mobile {
    static String type = "Smartphone"; // Static variable

    String brand; // Instance variable
    int price;    // Instance variable

    // Constructor
    Mobile(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    // Display details of the mobile
    void displayDetails() {
        System.out.println("Brand: " + brand + ", Price: " + price + ", Type: " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        // Access the static variable using the class name
        System.out.println("Mobile Type (using class name): " + Mobile.type);

        // Create objects of the Mobile class
        Mobile m1 = new Mobile("Samsung", 1200);
        Mobile m2 = new Mobile("Apple", 1500);

        // Access the static variable using objects (not recommended)
        System.out.println("Mobile Type (using object m1): " + m1.type);
        System.out.println("Mobile Type (using object m2): " + m2.type);

        // Display details of each mobile
        m1.displayDetails();
        m2.displayDetails();

        // Modify the static variable using the class name
        Mobile.type = "Smartphone with AI";

        // Check the updated static variable for all instances
        System.out.println("\nAfter modifying the static variable:");
        m1.displayDetails();
        m2.displayDetails();
    }
}
