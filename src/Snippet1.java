import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;
import Queue.Impl_StaticArrayBasedQueue;

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

public class Snippet1 {

    public static void main(String[] args) {

        MyStaticArrayBasedQueue<Integer> antrian = new MyStaticArrayBasedQueue<>(20);

        for (int i = 0; i < 10; i++) {
            antrian.enQueue(2);
            antrian.enQueue(3);
        }

        int[] cs = new int[2];

        int jumlahPelanggan = 0;
        int minute = 20;

        for (int i = 0; i < minute; i++) {
            for(int j = 0; j < 2; j++) if (cs[j] != 0) cs[j]--;

            for(int k = 0; k < 2; k++) {
                if (cs[k] == 0) {
                    cs[k] += antrian.deQueue();
                    jumlahPelanggan++;
                    break;
                }
            }
        }

        System.out.println(jumlahPelanggan);

    }

}
