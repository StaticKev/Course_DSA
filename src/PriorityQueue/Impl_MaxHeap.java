package PriorityQueue;

class MaxPQ<T extends Comparable<T>> {
    T[] heap;
    int size;

    @SuppressWarnings("unchecked")
    public MaxPQ(int capacity) {
        heap = (T[]) new Object[capacity + 1];
        size = 0;
    }

    public void insert(T value) {
        if (size == heap.length - 1) resize();

        heap[++size] = value;
        swim(size);
    }

    public void deleteMax() {
        heap[1] = heap[size];
        heap[size] = null;

        int currIndex = 1;

        while (currIndex * 2 + 1 <= size) {
            T currNode = heap[currIndex];
            int childIndex;

            if (heap[currIndex * 2].compareTo(heap[currIndex * 2 + 1]) > 0) childIndex = currIndex * 2;
            else childIndex = currIndex * 2 + 1;

            if (currNode.compareTo(heap[childIndex]) < 0) {
                heap[currIndex] = heap[childIndex];
                heap[childIndex] = currNode;
                currIndex = childIndex;
            } else break;
        }

        size--;
    }

    public void deleteMin() {

    }

    private void swim(int k) {
        while (k > 1 && heap[k / 2].compareTo(heap[k]) < 0) {
            T temp = heap[k];
            heap[k] = heap[k / 2];
            heap[k / 2] = temp;
            k = k / 2;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newHeap = (T[]) new Object[2 * heap.length];

        if (heap.length - 1 >= 0) System.arraycopy(heap, 1, newHeap, 1, heap.length - 1);

        this.heap = newHeap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class Impl_MaxHeap {
    public static void main(String[] args) {

        MaxPQ<Integer> pq = new MaxPQ<>(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());

    }
}
