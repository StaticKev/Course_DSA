package Queue;

import java.util.NoSuchElementException;

class Singly_Node<T> {
    T value;
    Singly_Node<T> next;

    public Singly_Node(T value) {
        this.value = value;
        this.next = null;
    }
}

class MyLinkedListBasedQueue<T> {

    Singly_Node<T> front;
    Singly_Node<T> rear;
    int length;

    MyLinkedListBasedQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(T value) {
        Singly_Node<T> newNode = new Singly_Node<>(value);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public T dequeue() {
        T value;
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty, cannot dequeue!");
        }
        value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return front.value;
        }
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }
}

public class Impl_LinkListBasedQueue {
    public static void main(String[] args) {
        MyLinkedListBasedQueue<Integer> queue = new MyLinkedListBasedQueue<>();
        queue.enqueue(10);
        queue.enqueue(100);
        queue.enqueue(1000);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
