package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Problem_NextGreaterElement {

    public static void main(String[] args) {

        Integer[] arr = {4, 7, 3, 4, 8, 1};
        Integer[] result = nextGreaterElement(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));

    }

    private static Integer[] nextGreaterElement(Integer[] arr) {
        Integer[] result = new Integer[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return result;
    }

}
