// Define the Student class
class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student details
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        // ********** Approach 1: Create objects first, then assign to an array **********
        System.out.println("Approach 1: Create objects first, then assign to an array");

        // Create individual Student objects
        Student s1 = new Student("Alice", 20);
        Student s2 = new Student("Bob", 22);
        Student s3 = new Student("Charlie", 19);

        // Create an array and assign the objects
        Student students1[] = new Student[3];
        students1[0] = s1;
        students1[1] = s2;
        students1[2] = s3;

        // Access and display each object using a for loop
        System.out.println("Accessing objects using the array (Approach 1):");
        for (Student student : students1) {
            student.display();
        }

        // ********** Approach 2: Declare array first, then initialize each element **********
        System.out.println("\nApproach 2: Declare array first, then initialize each element");

        // Declare and initialize an array of Student objects
        Student students2[] = new Student[3];

        // Initialize each element in the array
        students2[0] = new Student("Dave", 21);
        students2[1] = new Student("Eve", 23);
        students2[2] = new Student("Frank", 20);

        // Access and display each object using a for loop
        System.out.println("Accessing objects using the array (Approach 2):");
        for (Student student : students2) {
            student.display();
        }
    }
}
