package Sort;

import java.util.Arrays;

public class BubbleSort_Impl {

    public static void main(String[] args) {

        int[] arr = {5, 1, 9, 2, 10, 15, 20, 19, 11, 3};

        System.out.println("Sorted array -> " + Arrays.toString(sort(arr)));
    }

    static int[] sort(int[] arr){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
        return arr;
    }

}
