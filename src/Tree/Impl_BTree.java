package Tree;

import java.lang.reflect.Array;

class MyBTree<T extends Comparable<T>> {
    class BTreeNode {
        T[] keys;
        int t;
        BTreeNode[] children;
        int keysCount;
        boolean leaf;

        @SuppressWarnings("unchecked")
        public BTreeNode(int t, boolean isLeaf) {
            this.t = t;
            this.keys = (T[]) new Object[2 * t - 1];
            this.children = (BTreeNode[]) Array.newInstance(BTreeNode.class, 2 * t);
            this.keysCount = 0;
            this.leaf = isLeaf;
        }

        void insertNonFull(T value) {
            int i = keysCount - 1;
            if (leaf) {
                while (i >= 0 && keys[i].compareTo(value) > 0) {
                    keys[i + 1] = keys[i];
                    i--;
                }
                keys[i + 1] = value;
                keysCount++;
            } else {
                while (i >= 0 && keys[i].compareTo(value) > 0) {
                    i--;
                }
                if (children[i + 1].keysCount == 2 * t - 1) {
                    splitChild(i + 1, children[i + 1]);
                    if (keys[i].compareTo(value) < 0) {
                        i++;
                    }
                }
                children[i + 1].insertNonFull(value);
            }
        }

        void splitChild(int i, BTreeNode child) {
            BTreeNode childHalf = new BTreeNode(child.t, child.leaf);
            childHalf.keysCount = t - 1;
            for (int j = 0; j < t - 1; j++) {
                childHalf.keys[j] = child.keys[j + t];
            }
            if (!child.leaf) {
                for (int j = 0; j < t; j++) {
                    childHalf.children[j] = child.children[j + t];
                }
            }
            child.keysCount = t - 1;
            for (int j = keysCount; j > i; j--) {
                children[j + 1] = children[j];
            }
            children[i + 1] = childHalf;
            for (int j = keysCount - 1; j >= i; j--) {
                keys[j + 1] = keys[j];
            }
            keys[i] = child.keys[t - 1];
            keysCount++;
        }

        void traverse() {
            for (int i = 0; i < keysCount; i++) {
                if (!leaf) {
                    children[i].traverse();
                }
                System.out.print(" " + keys[i]);
            }
            if (!leaf) {
                children[keysCount].traverse();
            }
        }

        BTreeNode search(T k) {
            int i = 0;
            while (i < keysCount && keys[i].compareTo(k) < 0) {
                i++;
            }
            if (i < keysCount && keys[i].compareTo(k) == 0) {
                return this;
            }
            if (leaf) {
                return null;
            }
            return children[i].search(k);
        }

    }

    int t; // Minimum degree
    BTreeNode root;

    public MyBTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void traverse() {
        if (this.root != null) this.root.traverse();
    }

    public BTreeNode search(T value) {
        return root == null ? null : root.search(value);
    }

    // Skenario Insertion:
    // - Insertion saat root adalah null
    // -
    void insert(T value) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = value;
            root.keysCount = 1;
        } else {
            if (root.keysCount == 2 * t - 1) {
                BTreeNode newRoot = new BTreeNode(t, false);
                newRoot.children[0] = root;
                newRoot.splitChild(0, root);
                int i = 0;
                if (newRoot.keys[0].compareTo(value) < 0) {
                    i++;
                }
                newRoot.children[i].insertNonFull(value);
                root = newRoot;
            } else {
                root.insertNonFull(value);
            }
        }
    }

}

public class Impl_BTree {

    public static void main(String[] args) {

    }
}
