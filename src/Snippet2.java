import java.util.Scanner;

public class Snippet2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];

            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            String command = scanner.next();

            int[] result = new int[n];

            int leftptr = 0;
            int rightptr = n - 1;

            for (int i = 0; i < n; i++) {

                int res = 1;
                for (int j = leftptr; j <= rightptr; j++) {
                    res *= arr[j];
                }
                res %= m;
                result[i] = res;

                if (command.charAt(i) == 'L') {
                    leftptr++;
                } else {
                    rightptr--;
                }
            }

            for (int i : result) {
                System.out.print(i + " ");
            }
        }

    }

}
