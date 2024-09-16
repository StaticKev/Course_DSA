package Tree;

import java.lang.reflect.Array;

class MyBTree<T extends Comparable<T>> {
    class BTreeNode {
        int t;
        final T[] keys;
        final BTreeNode[] children;
        int keysCount;
        boolean isLeaf;

        @SuppressWarnings("unchecked")
        public BTreeNode(int t, boolean isLeaf) {
            this.t = t;
            this.keys = (T[]) new Object[2 * t - 1];
            this.children = (BTreeNode[]) Array.newInstance(BTreeNode.class, 2 * t);
            this.keysCount = 0;
            this.isLeaf = isLeaf;
        }

        public void insertNonFull(T value) {
            int i = keysCount - 1;

        }

        // Method untuk memasukkan value dalam sebuah node.
        public void insertKey(T value) {
            // Cek seluruh key pada node ini, menghasilkan 4 skenario:
            // 1) Jika nilai pada indeks ke-i adalah null maka tugaskan nilai yang ingin
            //    dimasukkan pada indeks tersebut. Karena pengisian key dimulai dari indeks awal,
            //    dan insertion dan deletion hanya perlu menggeser key ke kanan atau ke kiri maka,
            //    tidak mungkin ada elemen dengan nilai non-null di sebelah kanan elemen dengan
            //    nilai null.
            // 2) Jika nilai pada indeks ke-1 sama dengan nilai yang ingin dimasukkan, return.
            //    Karena tidak boleh ada nilai duplikat dalam tree.
            // 3) Jika key yang dibandingkan lebih kecil, lanjutkan pencarian.
            // 4) Key yang dibandingkan lebih besar, geser elemen dengan indeks 'i' dan seluruh
            //    elemen di sebelah kanannya sebanyak 1 indeks ke kanan. (NOTE: Kecualikan indeks
            //    terakhir saat menggeser!)
            for (int i = 0; i < keysCount; i++) {
                if (keys[i] != null) {
                    // Nilai duplikat
                    if (value.compareTo(keys[i]) == 0) return;
                    // Nilai lebih kecil dari key
                    else if (value.compareTo(keys[i]) < 0) continue;

                    // Menggeser elemen
                    for (int j = keysCount - 2; j >= i; j--) {
                        keys[j + 1] = keys[j];
                    }
                }

                // Menugaskan nilai pada indeks tertentu pada 'keys'.
                keys[i] = value;
                keysCount++;
                break;
            }
        }
    }

    int t; // Minimum degree
    BTreeNode root;

    public MyBTree(int t) {
        this.root = null;
        this.t = t;
    }

    void insert(T value) {
        if (value == null) throw new IllegalArgumentException("Null value not allowed here!");

        insert(root, value);
    }

    private void insert(BTreeNode node, T value) {
        
    }
}

public class Impl_BTree {

    public static void main(String[] args) {

    }
}
