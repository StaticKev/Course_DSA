package Array;

import java.util.Arrays;

public class Impl_Array {

    public static void main(String[] args) {

        // Creating and array
        int[] myNumbers = new int[10];
        int[] myNumbers2 = {1, 2, 3, 4, 5, 6};

        // Accessing an array
        System.out.println(myNumbers[0]);

        // Getting the length of an array
        System.out.println(myNumbers.length);

        // Printing every single element of an array
        System.out.println(Arrays.toString(myNumbers));

        // Creating a 2 dimensional array
        int[][] matrix1A = new int[4][5];
        int[][] matrix1B = {
                {0, 1, 0, 2, 3},
                {4, 5, 6, 3, 8},
                {2, 7, 8, 9, 1}
        };

        // Ragged array
        int[][] matrix2 = {
                {0, 1},
                {4, 5, 6, 3, 8},
                {2, 7, 8}
        };

    }

}