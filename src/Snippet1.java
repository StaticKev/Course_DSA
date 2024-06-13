import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

public class Snippet1 {

    public static void main(String[] args) {

//        Stack<Integer> myStack = new Stack<>();
//        myStack.push(12);
//        myStack.push(43);
//        myStack.push(100);
//        myStack.push(200);
//        System.out.println(myStack.peek());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.peek());

        Queue<Integer> myQueue = new SynchronousQueue<>();

        myQueue.offer(20);

//        myQueue.add(40);
//        myQueue.add(9);
//        myQueue.add(120);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());

    }

}
