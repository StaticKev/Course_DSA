package Queue;

class MyCircularQueue<T> {
    private final int size;
    private final T[] queue;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public MyCircularQueue(int size) {
        this.size = size;
        queue = (T[]) new Object[size];

        front = -1;
        rear = -1;
    }

    public void enqueue(T item) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = item; // rear = 0;
            System.out.println("Rear: " + rear);
        } else {
            rear = (rear + 1) % size; // Start di 1
            System.out.println("Rear: " + rear);
            if (rear == front) {
                rear = (rear - 1 + size) % size; // Mengembalikan nilai sebelumnya
                throw new IllegalStateException("Queue is full, cannot enqueue!");
            } else {
                queue[rear] = item;
            }
        }
    }

    public T dequeue() {
        T item = null;

        if (!isEmpty()) {
            item = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
                System.out.println("Front = " + front);
            } else {
                front = (front + 1) % size; // Increment front
                System.out.println("Front: " + front);
            }
        } else {
            throw new IllegalStateException("Queue is empty, cannot dequeue!");
        }

        return item;
    }

    public T peek() {
        if (!isEmpty()) {
            return queue[front];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    // Rear mendahului front
}

// INCORRECT APPROACH
//class MyCircularQueue<T> {
//    private final T[] queue;
//    private int front;
//    private int rear;
//    private boolean rearGotPreceded;
//
//    @SuppressWarnings("unchecked")
//    public MyCircularQueue(int length) {
//        if (length <= 0) {
//            throw new IllegalArgumentException("Queue size must be greater than 0!");
//        }
//        queue = (T[]) new Object[length];
//        front = -1;
//        rear = -1;
//        rearGotPreceded = false;
//    }
//
//    public void enQueue(T value) {
//        System.out.println("=============== ENQUEUE CALL ===============");
//        if (front == -1) {
//            front = 0;
//        }
//        rear++;
//
//        if (rear == queue.length) {
//            if (front == 0) {
//                rear--;
//                throw new IllegalStateException("Queue is full!");
//            } else {
//                rear = 0;
//                System.out.println("Front = " + front);
//                queue[rear] = value;
//                System.out.println("Rear = " + rear);
//            }
//        } else {
//            System.out.println("Front: "+ front);
//            System.out.println("Rear: " + rear);
//            if (rear != 0 && rear == front) {
//                rear--;
//                throw new IllegalStateException("Queue is full!");
//            } else {
//                queue[rear] = value;
//            }
//        }
//        rearGotPreceded = false;
//    }
//
//    public T deQueue() {
//        System.out.println("=============== DEQUEUE CALL ===============");
//        System.out.println(rearGotPreceded);
//        System.out.println("Front: " + front);
//        if (isEmpty()) {
//            throw new IllegalStateException("Queue is empty!");
//        } else {
//            if (front == queue.length && rear != queue.length - 1) {
//                front = 0;
//            }
//            if (front > rear && !rearGotPreceded) {
//                rearGotPreceded = true;
//            }
//            return queue[front++];
//        }
//    }
//
//    public T peek() {
//        if (!isEmpty()) {
//            return queue[front];
//        } else {
//            throw new IllegalStateException("Queue is empty!");
//        }
//    }
//
//    public boolean isEmpty() {
//        boolean cond1 = front == -1;
//        boolean cond2 = front == queue.length && rear == queue.length - 1;
//        boolean cond3 = rear + 1 == front && rearGotPreceded;
//        return cond1 || cond2 || cond3;
//    }
//}

public class Impl_CircularQueue {

    public static void main(String[] args) {
        MyCircularQueue<Integer> circularQueue = new MyCircularQueue<>(4);
        circularQueue.enqueue(3);
        circularQueue.enqueue(5);
        circularQueue.enqueue(10);
        circularQueue.enqueue(34);

        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());

        circularQueue.enqueue(100);
        circularQueue.enqueue(200);

        System.out.println("\n");
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());

        circularQueue.enqueue(5);
        circularQueue.enqueue(10);
        circularQueue.enqueue(34);

        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
    }
}
