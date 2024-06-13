package Stack;

import java.util.EmptyStackException;

class MyStaticStack<T> {
    T[] stack;
    int top;

    @SuppressWarnings("unchecked")
    public MyStaticStack(int length) {
        stack = (T[]) new Object[length];
        top = -1;
    }

    public void push(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        stack[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = stack[top];
        stack[--top] = null;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return top == size() - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class Impl_StaticStack<T> {

    public static void main(String[] args) {



    }

}
