package Tree;

class MyBST <T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public MyBST() {}
    public MyBST(T initialValue) {
        root = new BinaryTreeNode<>(initialValue);
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    public BinaryTreeNode<T> insert(BinaryTreeNode<T> root, T value) {
        if (root == null) {
            root = new BinaryTreeNode<>(value);
            return root;
        }

        if (value.compareTo(root.data) < 0) root.left = insert(root.left, value);
        else if (value.compareTo(root.data) > 0) root.right = insert(root.right, value);

        return root;
    }

    public void delete(T value) {
        if (root == null) throw new IllegalArgumentException("Tree is empty!");
        else delete(root, value);
    }

    public BinaryTreeNode<T> delete(BinaryTreeNode<T> root, T value) {
        if (root == null) return null;

        if (value.compareTo(root.data) < 0) root.left = delete(root.left, value);
        else if (value.compareTo(root.data) > 0) root.right = delete(root.right, value);
        else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                BinaryTreeNode<T> successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }
        }
        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(BinaryTreeNode<T> root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(BinaryTreeNode<T> root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(BinaryTreeNode<T> root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public BinaryTreeNode<T> search(T key) {
        return search(root, key);
    }

    public BinaryTreeNode<T> search(BinaryTreeNode<T> root, T key) {
        if (root == null || root.data == key) return root;

        if (key.compareTo(root.data) < 0) return search(root.left, key);
        else return search(root.right, key);
    }

}

public class Impl_BinarySearchTree {

    public static void main(String[] args) {
        MyBST<Integer> bst = new MyBST<>();
        bst.insert(6);
        bst.insert(90);
        bst.insert(30);
        bst.insert(7);

        bst.inOrder();
        System.out.println();
        bst.preOrder();
        System.out.println();
        bst.postOrder();

        if (bst.search(30) != null) System.out.println("\n\nKey found!");
        else System.out.println("Key not found!");

        bst.delete(90);
        bst.inOrder();

    }

    // Fungsi untuk menentukan apakah sebuah tree adalah BST.
    public static <T extends Comparable<T>> boolean isBST(BinaryTreeNode<T> root, Long min, Long max) {
        if (root == null) return true;

        if (min.compareTo((Long)root.data) <= 0 ||
                max.compareTo((Long)root.data) >= 0) {
            return false;
        }

        boolean leftIsValid = isBST(root.left, min, (Long)root.data);
        if (leftIsValid) {
            return isBST(root.right, (Long)root.data, max);
        }

        return false;
    }

}
