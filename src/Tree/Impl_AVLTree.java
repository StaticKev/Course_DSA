package Tree;

import java.util.LinkedList;

class MyAvlTree<T extends Comparable<T>> {
    class AVLTreeNode {
        T data;
        AVLTreeNode left;
        AVLTreeNode right;
        int balanceFactor;
        int height;

        public AVLTreeNode(T data) {
            this.data = data;
            height = 0;
        }

    }

    AVLTreeNode root;

    void insert(T data) {
        root = insert(data, root);
    }

    private AVLTreeNode insert(T data, AVLTreeNode node) {
        // Base case: Membuat dan mengembalikan node baru sebagai left/right child
        // dari node yang terakhir kali dikunjungi. Pemanggilan secara rekursif
        // dilakukan untuk mencari node yang paling bawah, disertai kondisi yang
        // diperlukan untuk mempertahankan struktur BST.
        if (node == null) return new AVLTreeNode(data);

        // Pergi ke node kiri apabila data yang ingin dimasukkan lebih kecil
        // daripada data yang dimiliki oleh node yang sedang dikunjungi.
        if (data.compareTo(node.data) < 0) node.left = insert(data, node.left);
        // Pergi ke node kanan apabila data yang ingin dimasukkan lebih besar
        // daripada data yang dimiliki oleh node yang sedang dikunjungi.
        else if (data.compareTo(node.data) > 0) node.right = insert(data, node.right);
        // Kembalikan node karena nilai yang ingin ditambahkan sudah ada. Dalam
        // BST tidak boleh ada nilai duplikat.
        else return node;

        // Perintah dibawah baru akan dieksekusi apabila data tidak duplikat.
        // Fungsi `updateHeight` digunakan untuk memperbarui tinggi node yang
        // sedang dikunjungi, setelah menambahkan node baru.
        updateHeight(node);
        // Fungsi `applyRotation` digunakan untuk mengecek balance factor
        // dan melakukan rotasi setelah node baru ditambah, untuk mempertahankan
        // keseimbangan tree apabila diperlukan (BF < -1 || BF > 1).
        return applyRotation(node);
    }

    void delete(T data) {
        root = delete(data, root);
    }

    private AVLTreeNode delete(T data, AVLTreeNode node) {
        // Base case: Mengembalikan null jika telah mencapai leaf, dan nilai
        // tidak ditemukan.
        if (node == null) return null;

        // Pergi ke node kiri apabila nilai pada node yang sedang dikunjungi
        // lebih kecil daripada nilai yang ingin dibandingkan.
        if (data.compareTo(node.data) < 0) node.left = delete(data, node.left);
            // Pergi ke node kanan apabila nilai pada node yang sedang dikunjungi
            // lebih besar daripada nilai yang ingin dibandingkan.
        else if (data.compareTo(node.data) > 0) node.right = delete(data, node.right);
        // Hapus node apabila nilai pada node yang sedang dikunjungi sama. Dalam
        // menghapus, seluruh child node dari node yang ingin dihapus tidak boleh
        // ikut terhapus, melainkan harus diletakkan pada susunan tertentu
        // menggantikan node yang ingin dihapus.
        else {
            // Menggantikan node yang ingin dihapus dengan left child apabila
            // tidak ada right child.
            if (node.left == null) return node.right;
            // Menggantikan node yang ingin dihapus dengan right child apabila
            // tidak ada left child.
            else if (node.right == null) return node.left;
            // Node memiliki 2 child, sehingga dapat dipilih node mana yang
            // akan menggantikan node yang akan dihapus. Untuk mempertahankan
            // struktur BST, maka node yang dihapus dapat digantikan oleh nilai
            // minimum atau maksimum subtree dari node yang akan dihapus. Dimana
            // node yang mengandung nilai maksimum atau minimum adalah leaf node
            // yang nantinya perlu dihapus setelah posisinya ditukar.
            else {
                // Mengambil nilai maksimum dari left child
                node.data = getMax(node.left);
                // Menghapus leaf node dari nilai yang akan ditukar
                node.left = delete(node.data, node.left);

                // Mengambil nilai minimum dari right child
//                node.data = getMin(node.right);
                // Menghapus leaf node dari nilai yang akan ditukar
//                node.right = delete(node.data, node.right);
            }
        }

        updateHeight(node);
        return applyRotation(node);
    }

    T getMax() {
        if (isEmpty()) return null;
        AVLTreeNode node = root;
        while (node.right != null) node = node.right;
        return node.data;
    }

    private T getMax(AVLTreeNode node) {
        if (node == null) return null;
        while (node.right != null) node = node.right;
        return node.data;
    }

    T getMin() {
        if (isEmpty()) return null;
        AVLTreeNode node = root;
        while (node.left != null) node = node.left;
        return node.data;
    }

    private T getMin(AVLTreeNode node) {
        if (node == null) return null;
        while (node.left != null) node = node.left;
        return node.data;
    }

    boolean isEmpty() {
        return root == null;
    }

    public LinkedList<T> levelOrderTraversal() {
        LinkedList<T> result = new LinkedList<>();

        MyLinkedListBasedQueue<AVLTreeNode> queue = new MyLinkedListBasedQueue<>();
        queue.enqueue(root);

        while(!queue.isEmpty()) {
            AVLTreeNode current = queue.dequeue();
            result.add(current.data);
            System.out.println(current.height + " - " + current.data);
            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }

        return result;
    }

    // ISSUE: Apakah ada potensi dimana perlu dilakukan rotasi terhadap dua arah
    // pada level yang sama? Kok pake multiple if statement?
    private AVLTreeNode applyRotation(AVLTreeNode node) {
        // Menghitung balance factor dari node yang sedang dikunjungi.
        int balanceFactor = countBalanceFactor(node);
        System.out.println("BF = " + balanceFactor + " | Node Value: " + node.data + " | Height: " + node.height);
        // Memeriksa apakah balance factor lebih besar daripada 1 (berat ke kiri)
        if (balanceFactor > 1) {
            // Memeriksa apakah balance factor dari node kiri lebih besar. Jika
            // ya maka, terjadi skenario LR imbalance. Dimana perlu dilakukan
            // rotasi ke kiri pada child node terlebih dahulu.
            if (countBalanceFactor(node.left) < 0) node.left = rotateLeft(node.left);
            // Lakukan rotasi ke kanan
            return rotateRight(node);
        }
        // Memeriksa apakah balance factor lebih besar daripada 1 (berat ke kiri)
        if (balanceFactor < -1) {
            // Memeriksa apakah balance factor dari node kanan lebih besar. Jika
            // ya maka, terjadi skenario RL imbalance. Dimana perlu dilakukan
            // rotasi ke kanan pada child node terlebih dahulu.
            if (countBalanceFactor(node.right) > 0) node.right = rotateRight(node.right);
            // Lakukan rotasi ke kiri
            return rotateLeft(node);
        }
        // Kembalikan node yang balance factornya sudah sesuai.
        return node;
    }

    // Fungsi untuk melakukan rotasi ke kanan
    private AVLTreeNode rotateRight(AVLTreeNode node) {
        // Simpan left child dari node yang menjadi poros.
        AVLTreeNode leftNode = node.left;
        // Simpan right child dari node yang akan menjadi root. Nantinya node
        // ini akan ikut pindah bersamaan dengan node poros, sebagai left child
        // nya.
        AVLTreeNode centerNode = leftNode.right;
        // Pindahkan posisi root node sebagai right child dari root yang baru.
        leftNode.right = node;
        // Sertakan right child dari node yang akan menjadi root sebagai left
        // child dari root yang lama.
        node.left = centerNode;
        // Update tinggi dari masing-masing node.
        updateHeight(node);
        updateHeight(leftNode);

        return leftNode;
    }

    // Fungsi untuk melakukan rotasi ke kiri
    private AVLTreeNode rotateLeft(AVLTreeNode node) {
        // Simpan right child dari node yang menjadi poros.
        AVLTreeNode rightNode = node.right;
        // Simpan left child dari node yang akan menjadi root. Nantinya node
        // ini akan ikut pindah bersamaan dengan node poros, sebagai right child
        // nya.
        AVLTreeNode centerNode = rightNode.left;
        // Pindahkan posisi root node sebagai left child dari root yang baru.
        rightNode.left = node;
        // Sertakan left child dari node yang akan menjadi root sebagai right
        // child dari root yang lama.
        node.right = centerNode;
        // Update tinggi dari masing-masing node.
        updateHeight(node);
        updateHeight(rightNode);

        return rightNode;
    }

    private int countBalanceFactor(AVLTreeNode node) {
        // Jika node tidak null, maka hitung balance factornya. Jika null
        // maka, balance factornya adalah 0.
        return node != null ? height(node.left) - height(node.right) : 0;
    }

    private void updateHeight(AVLTreeNode node) {
        // Mengupdate height dari sebuah node.
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    // WTF IS DIS?
    private int height(AVLTreeNode node) {
        // Jika node tidak null, maka kembalikan height nya. Jika null maka,
        // ketinggiannya adalah -1. Mengapa -1? Karena initial value dari
        // height sebuah node adalah 0. Sehingga jika null mengembalikan 0,
        // maka akan sama dengan node yang memiliki ketinggian 0. Dimana
        // saat perhitungan balance factor dilakukan untuk sebuah node yang
        // hanya memiliki satu child, balance factornya adalah 0, yang
        // seharusnya 1 atau -1 karena memiliki child.
        return node != null ? node.height : -1;
    }

}

public class Impl_AVLTree {
    public static void main(String[] args) {

        MyAvlTree<Integer> avlTree = new MyAvlTree<>();
        System.out.println("Tree is empty: " + avlTree.isEmpty() + "\n");

        // Inserting a value into an avl tree
        avlTree.insert(20);
        avlTree.insert(40);
        avlTree.insert(60);
        avlTree.insert(80);
        avlTree.insert(100);
        avlTree.insert(120);
        avlTree.insert(140);
        avlTree.insert(180);

        // Level order traversal
        System.out.println("Level order traversal result: ");
        for (Integer i : avlTree.levelOrderTraversal()) System.out.print(i + " ");

        // Getting the maximum & minimum value in a AVL Tree
        System.out.println("\n\nMax Value = " + avlTree.getMax());
        System.out.println("Min Value = " + avlTree.getMin());

        // Deleting a value from an AVL Tree
        avlTree.delete(80);
        System.out.println("\nLevel order traversal result: ");
        for (Integer i : avlTree.levelOrderTraversal()) System.out.print(i + " ");

    }
}
