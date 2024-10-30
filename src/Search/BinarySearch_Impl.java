package Search;

public class BinarySearch_Impl {

    public static void main(String[] args) {

        int[] arr = {5, 1, 9, 2, 10, 15, 20, 19, 11, 3};

        System.out.println("Nilai ditemukan pada indeks: " + search(arr, 10));

    }

    public static int search(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == value) return mid;
            if (value < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

}
