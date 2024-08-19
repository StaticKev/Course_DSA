package Tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class MyLinkedListBasedQueue<T> {
    @SuppressWarnings("InnerClassMayBeStatic")
    class Singly_Node <T_in> {
        T_in value;
        Singly_Node<T_in> next;

        public Singly_Node(T_in value) {
            this.value = value;
            this.next = null;
        }
    }
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

public class Algorithm_LevelOrderTraversal {
    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);

        // Depth-1
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);

        // Depth-2
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        // Depth-3
        root.left.left.left = new BinaryTreeNode<>(8);
        root.left.left.right = new BinaryTreeNode<>(9);
        root.left.right.left = new BinaryTreeNode<>(10);
        root.right.left.left = new BinaryTreeNode<>(11);
        root.right.left.right = new BinaryTreeNode<>(12);
        root.right.right.left = new BinaryTreeNode<>(13);
        root.right.right.right = new BinaryTreeNode<>(14);

        // Depth-4
        root.left.left.left.left = new BinaryTreeNode<>(15);
        root.left.left.left.right = new BinaryTreeNode<>(16);
        root.left.left.right.left = new BinaryTreeNode<>(17);
        root.left.left.right.right = new BinaryTreeNode<>(18);
        root.left.right.left.left = new BinaryTreeNode<>(19);
        root.right.left.left.left = new BinaryTreeNode<>(20);
        root.right.left.right.left = new BinaryTreeNode<>(21);
        root.right.right.right.left = new BinaryTreeNode<>(22);
        root.right.right.right.right = new BinaryTreeNode<>(23);

        // Depth-5
        root.left.left.left.right.left = new BinaryTreeNode<>(24);
        root.left.left.right.left.left = new BinaryTreeNode<>(25);
        root.left.right.left.left.left = new BinaryTreeNode<>(26);
        root.right.left.right.left.left = new BinaryTreeNode<>(27);
        root.right.left.right.left.right = new BinaryTreeNode<>(28);
        root.right.right.right.left.left = new BinaryTreeNode<>(29);
        root.right.right.right.right.left = new BinaryTreeNode<>(30);
        root.right.right.right.right.right = new BinaryTreeNode<>(31);

        // Depth-6
        root.left.left.left.right.left.left = new BinaryTreeNode<>(32);
        root.left.right.left.left.left.left = new BinaryTreeNode<>(33);
        root.left.right.left.left.left.right = new BinaryTreeNode<>(34);

        LinkedList<Integer> traversalResult1 = levelOrderTraversal(root);
        for (int value : traversalResult1) System.out.println(value);

//        LinkedList<Integer> traversalResult2 = levelOrderTraversal(root, false);
//        for (int value : traversalResult2) System.out.println(value);

    }

    // Iterative
    public static <T> LinkedList<T> levelOrderTraversal(BinaryTreeNode<T> root) {
        LinkedList<T> result = new LinkedList<>();

        MyLinkedListBasedQueue<BinaryTreeNode<T>> queue = new MyLinkedListBasedQueue<>();
        queue.enqueue(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();
            result.add(current.data);
            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }

        return result;
    }

    // Recursive (Ndak efektif)
    private static <T> LinkedList<T> levelOrderTraversal(BinaryTreeNode<T> root, boolean dummy) {
        class RecursionHelper {
            void levelOrderTraversal(LinkedList<T> result, BinaryTreeNode<T> root, int depthToTraverse) {
                depthToTraverse--;

                if (depthToTraverse == 0) {
                    result.add(root.data);
                } else {
                    if (root.left != null) levelOrderTraversal(result, root.left, depthToTraverse);
                    if (root.right != null) levelOrderTraversal(result, root.right, depthToTraverse);
                }
            }
            int calculateDepth(BinaryTreeNode<T> root) {
                if (root == null) return 0;

                int leftDepth = calculateDepth(root.left);
                int rightDepth = calculateDepth(root.right);

                return Math.max(leftDepth, rightDepth) + 1;
            }
        }

        RecursionHelper helper = new RecursionHelper();
        LinkedList<T> result = new LinkedList<>();

        if (root == null) throw new IllegalStateException("Root is null!");
        else result.add(root.data);

        // Ini bisa dihilangkan trus diganti while loop. Soalnya menghitung depth
        // dilakukan dengan menjelajahi seluruh node pada tree.
        int depth = helper.calculateDepth(root);

        for (int i = 1; i < depth; i++) {
            helper.levelOrderTraversal(result, root.left, i);
            helper.levelOrderTraversal(result, root.right, i);
        }

        return result;

    }

}


