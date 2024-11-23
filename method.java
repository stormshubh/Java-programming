// Java classes and objects
class Calculator {
    public int add(int n1, int n2) {
        int r = n1 + n2;
        return r;
    }
}

class Battle { // Class names in Java should start with an uppercase letter
    public void music() {
        System.out.println("Music is playing");
    }
}

public class Main {
    public static void main(String a[]) {
        int num1 = 4;
        int num2 = 5;

        Calculator calc = new Calculator();
        int res = calc.add(num1, num2);
        System.out.println(res);

        Battle obj = new Battle(); // Corrected the class name
        obj.music(); // Call the method on the object
    }
}
