package Tree;

import java.util.Stack;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class MyBinaryTree<T> {
    public BinaryTreeNode<T> root;

    public MyBinaryTree(T initialValue) {
        root = new BinaryTreeNode<>(initialValue);
    }

    // Pre-order Binary Tree Traversal (Recursive)
    public void preOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In-order Binary Tree Traversal (Recursive)
    public void inOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    // Post-order Binary Tree Traversal (Recursive)
    public void postOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.data);
    }

    // Pre-order Binary Tree Traversal (Iterative)
    // Metode ini mereplika bagaimana fungsi dipanggil.
    public void preOrder() {
        if (this.root == null) return;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> currentNode = stack.pop();
            System.out.println(currentNode.data);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    // In-order Binary Tree Traversal (Iterative)
    public void inOrder() {
        if (this.root == null) return;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> temp = root;

        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            temp = stack.pop();
            System.out.println(temp.data + " ");
            temp = temp.right;
        }
    }

    // Post-order Binary Tree Traversal (Iterative)
    public void postOrder() {
        if (this.root == null) return;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;
        while(current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                BinaryTreeNode<T> temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.println(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.println(temp.data + " ");
                    }
                }
                else {
                    current = temp;
                }
            }
        }
    }

}

public class Impl_BinaryTree<T> {

    public static void main(String[] args) {
        MyBinaryTree<Integer> binaryTree = new MyBinaryTree<>(1);

    }



}
