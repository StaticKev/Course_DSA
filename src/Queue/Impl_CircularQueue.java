package Queue;

class MyCircularQueue<T> {
    private final T[] queue;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public MyCircularQueue(int length) {
        queue = (T[]) new Object[length];
        front = -1;
        rear = -1;
    }

    public void enQueue(T value) {
        rear++;
        if (front == -1) {
            front = 0;
        }

        if (rear == queue.length && front > 0) {
            rear = 0;
        }

        if (rear == front && queue[rear + 1] != null) {
            throw new IllegalStateException("Queue is full!");
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

//    public T peek() {
//        if (!isEmpty()) {
//            return queue[front];
//        } else {
//            throw new IllegalStateException("Queue is empty!");
//        }
//    }

//    public boolean isFull() {
//        return rear == queue.length;
//    }

    public boolean isEmpty() {
//        return front == rear + 1 || front == -1;
        return front == -1;
    }
}

public class Impl_CircularQueue {

    public static void main(String[] args) {
        MyCircularQueue<Integer> circularQueue = new MyCircularQueue<>(4);
        circularQueue.enQueue(3);
        circularQueue.enQueue(5);
        circularQueue.enQueue(10);
        circularQueue.enQueue(34);
    }

}
