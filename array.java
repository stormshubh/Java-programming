import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        // Single-dimensional array declared and initialized with values
        int[] arr = {10, 20, 30, 40, 50};
        
        // Single-dimensional array with size declared first and values assigned later
        int[] arrLater = new int[5];
        arrLater[0] = 15;
        arrLater[1] = 25;
        arrLater[2] = 35;
        arrLater[3] = 45;
        arrLater[4] = 55;

        // Accessing and displaying elements
        System.out.println("Element at index 0: " + arr[0]);
        System.out.println("Array size: " + arr.length);

        // Using standard for loop to iterate
        System.out.println("Using standard for loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at index " + i + ": " + arr[i]);
        }

        // Using enhanced for loop to iterate
        System.out.println("Using enhanced for loop:");
        for (int value : arr) {
            System.out.println("Value: " + value);
        }

        // Multidimensional array with predefined values
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Predefined 2D Array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Multidimensional array: Declare size first, then input values
        Scanner scanner = new Scanner(System.in);
        int[][] userMatrix = new int[2][3]; // Declare a 2x3 array

        // Input values from the user
        System.out.println("\nEnter values for a 2x3 matrix:");
        for (int i = 0; i < userMatrix.length; i++) {
            for (int j = 0; j < userMatrix[i].length; j++) {
                System.out.print("Enter value for userMatrix[" + i + "][" + j + "]: ");
                userMatrix[i][j] = scanner.nextInt();
            }
        }

        // Display user-defined 2D array
        System.out.println("\nUser-defined 2D Array:");
        for (int i = 0; i < userMatrix.length; i++) {
            for (int j = 0; j < userMatrix[i].length; j++) {
                System.out.print(userMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Jagged array (rows with varying lengths)
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[] {1, 2, 3};
        jaggedArray[1] = new int[] {4, 5};
        jaggedArray[2] = new int[] {6, 7, 8, 9};

        // Display jagged array
        System.out.println("\nJagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
