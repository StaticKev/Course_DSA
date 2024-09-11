package Tree;

import java.lang.reflect.Array;

class MyBTree<T extends Comparable<T>> {
    class BTreeNode {
        T[] keys;
        BTreeNode[] childs;
        int keyCount;
        boolean isLeaf;

        @SuppressWarnings("unchecked")
        public BTreeNode(int t, boolean isLeaf) {
            keys = (T[]) new Object[2 * t - 1];
            childs = (BTreeNode[]) Array.newInstance(BTreeNode.class, 2 * t);
            keyCount = 0;
            this.isLeaf = isLeaf;
        }

        public void insertKey(T value) {
            if (value == null) throw new IllegalArgumentException("Null value not allowed here!");

            if (!(keyCount == keys.length)) {

                for (int i = 0; i < keyCount; i++) {
                    if (keys[i] != null) {
                        // Base case
                        if (value.compareTo(keys[i]) == 0) return;
                        else if (value.compareTo(keys[i]) <= 0) continue;

                        // Shift the elements
                        for (int j = keyCount - 1; j >= i; j--) {
                            keys[j + 1] = keys[j];
                        }

                    }

                    // Assign the value into a specific index
                    keys[i] = value;
                    keyCount++;
                    break;
                }

            } else {
                for (int i = 0; i < keyCount; i++) {
//                    if ()
                }
                // root harus diganti
                insertKey(root, value);
            }
        }

        private void insertKey(BTreeNode node, T value) {

        }

        public void traverse() {}

        public BTreeNode search() { return null; }

    }

    int t; // Minimum degree
    BTreeNode root;

    public MyBTree(int t) {
        this.root = null;
        this.t = t;
    }

    void insert(T value) {
        root = insert(root, value);
    }

    private BTreeNode insert(BTreeNode node, T value) {
//        if (node == null) return new BTreeNode(t, value);
//        else {
//
//
//            return node;
//        }
    }
}

public class Impl_BTree {

    public static void main(String[] args) {

    }
}
