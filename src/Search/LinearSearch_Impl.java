package Search;

public class LinearSearch_Impl {

    public static void main(String[] args) {

        int arr[] = {5, 1, 9, 2, 10, 15, 20};

        System.out.println("Nilai ditemukan pada indeks: " + search(arr, arr.length, 10));

    }

    public static int search(int[] arr, int length, int value) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
