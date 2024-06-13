package Others;

public class AsymptoticAnalysis {

    public static void main(String[] args) {

    }

    /*
         Complexity O(1) -> Constant
         l01: 4 unit of time
            | Access variable x
            | Access variable y
            | Sum x and y
            | Assign the result into a `result`
         l02:  2 unit of time
            | Access the `result` variable
            | Returns the result

         T = 4 + 2 = 6
         T = C
    */
    private static int printMe(int x, int y) {
        int result = x + y;
        return result;
    }

    /*
         Complexity O(n) -> Linear
         l01: 1 unit of time
            | Assigning value to `sum`
         l02: 6n + 4 unit of time
            | Create the value `i`
            | Repeat n + 1 times (final check before terminating the loop):
            |    + Access `i`
            |    + Access `n`
            |    + Compare the value of `i` and `n`
            | Repeat n times (increment):
            |    + Access the value of `i`
            |    + Increment the value
            |    + Assign it back to `i`
         l03: 4n unit of time
            | Access `sum`
            | Access `i`
            | Sum `sum` and `i`
            | Re-assign the result to `sum`
         l04: 2 unit of time
            | Access `sum`
            | Return the value

         T = 1 + 6n + 4 + 4n + 2
         T = 10n + 7
         T = n
     */
    public int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

}
