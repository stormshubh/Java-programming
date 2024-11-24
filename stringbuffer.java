public class StringBufferExample {
    public static void main(String[] args) {
        // Initialize a StringBuffer
        StringBuffer sb = new StringBuffer("Hello");

        // 1. Display initial capacity
        System.out.println("Initial capacity: " + sb.capacity()); // 16 + 5

        // 2. Append text
        sb.append(" World");
        System.out.println("After append: " + sb);

        // 3. Convert to String
        String result = sb.toString();
        System.out.println("StringBuffer as String: " + result);

        // 4. Delete a character
        sb.deleteCharAt(5); // Removes space
        System.out.println("After deleting character: " + sb);

        // 5. Insert text
        sb.insert(5, " Beautiful");
        System.out.println("After insert: " + sb);

        // 6. Set length
        sb.setLength(12);
        System.out.println("After setting length: " + sb);

        // 7. Ensure capacity
        sb.ensureCapacity(50);
        System.out.println("Capacity after ensureCapacity: " + sb.capacity());

        // 8. Substring
        String sub = sb.substring(6, 14);
        System.out.println("Substring: " + sub);
    }
}
