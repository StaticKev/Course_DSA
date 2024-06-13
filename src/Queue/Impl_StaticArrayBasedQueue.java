package Queue;

class MyStaticArrayBasedQueue<T> {
    private final T[] queue;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public MyStaticArrayBasedQueue(int length) {
        queue = (T[]) new Object[length];
        front = -1;
        rear = -1;
    }

    public void enQueue(T value) {
        rear++;
        if (front == -1) {
            front = 0;
        }

        if (isFull()) {
            rear--;
            throw new IllegalStateException("Queue is full");
        } else {
            queue[rear] = value;
        }

    }

    public T deQueue() {
        if (front == queue.length) {
            throw new IllegalStateException("End of queue reached!");
        } else if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        } else {
            return queue[front++];
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return queue[front];
        } else {
            throw new IllegalStateException("Queue is empty!");
        }
    }

    public boolean isFull() {
        return rear == queue.length;
    }

    public boolean isEmpty() {
        return front == rear + 1 || rear == -1;
    }

}

public class Impl_StaticArrayBasedQueue {

    public static void main(String[] args) {
        MyStaticArrayBasedQueue<Integer> queue = new MyStaticArrayBasedQueue<>(3);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }

}
