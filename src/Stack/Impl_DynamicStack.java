package Stack;

import java.util.EmptyStackException;

class Singly_Node<T> {
    T value;
    Singly_Node<T> next;

    public Singly_Node(T value) {
        this.value = value;
        this.next = null;
    }
}

class MyDynamicStack<T> {
    Singly_Node<T> top;
    int length;

    // Push new elements into the stack
    public void push(T data) {
        Singly_Node<T> newElement = new Singly_Node<>(data);
        newElement.next = top;
        top = newElement;
        length++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.value;
        top = top.next;
        length--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }


}

public class Impl_DynamicStack {

    public static void main(String[] args) {
        MyDynamicStack<Integer> myStack = new MyDynamicStack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(20);

        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());

    }

}
