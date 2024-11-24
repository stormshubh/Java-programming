public class Main {
    public static void main(String[] args) {
        // 1. String Declaration as a Class
        String str1 = new String("Java Programming");

        // 2. String Declaration as a Normal Variable
        String str2 = "Welcome to the World of Java!";

        // 3. Concatenation Using the '+' Operator
        String result1 = str1 + " - " + str2;
        System.out.println("Concatenation using '+': " + result1);

        // 4. Concatenation Using the concat() Method
        String result2 = str1.concat(" - ").concat(str2);
        System.out.println("Concatenation using concat(): " + result2);

        // 5. Using the charAt() Method
        char characterAtIndex = str2.charAt(11);  // Character at index 11
        System.out.println("Character at index 11: " + characterAtIndex);  // Output: 't'
    }
}

