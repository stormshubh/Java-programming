/*Below is a comprehensive example that incorporates **method overloading** by varying:
1. **Number of parameters**
2. **Type of parameters**
3. **Order of parameters***/

class Calculator {
    // Method 1: Adding two integers
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    // Method 2: Adding three integers
    public int add(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    // Method 3: Adding two doubles
    public double add(double n1, double n2) {
        return n1 + n2;
    }

    // Method 4: Adding a double and an integer (order: double first)
    public double add(double n1, int n2) {
        return n1 + n2;
    }

    // Method 5: Adding an integer and a double (order: int first)
    public double add(int n1, double n2) {
        return n1 + n2;
    }

    // Method 6: Adding an array of integers
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Method 1: Adding two integers
        int result1 = calc.add(5, 10);
        System.out.println("Sum of 5 and 10: " + result1);

        // Method 2: Adding three integers
        int result2 = calc.add(1, 2, 3);
        System.out.println("Sum of 1, 2, and 3: " + result2);

        // Method 3: Adding two doubles
        double result3 = calc.add(4.5, 3.5);
        System.out.println("Sum of 4.5 and 3.5: " + result3);

        // Method 4: Adding a double and an integer
        double result4 = calc.add(2.5, 4); // Calls add(double, int)
        System.out.println("Sum of 2.5 and 4: " + result4);

        // Method 5: Adding an integer and a double
        double result5 = calc.add(4, 2.5); // Calls add(int, double)
        System.out.println("Sum of 4 and 2.5: " + result5);

        // Method 6: Adding an array of integers
        int[] numbers = {1, 2, 3, 4, 5};
        int result6 = calc.add(numbers);
        System.out.println("Sum of array {1, 2, 3, 4, 5}: " + result6);
    }
}
