package LinkedList;

class Singly_Node<T> {
    T value;
    Singly_Node<T> next;

    public Singly_Node(T value) {
        this.value = value;
        this.next = null;
    }
}

class MySinglyLinkedList<T> {
    Singly_Node<T> head;
    int length;

    public MySinglyLinkedList() {
        head = null;
        length = 0;
    }

    // Menambahkan nilai di posisi paling belakang.
    public void add(T value) {
        Singly_Node<T> newNode = new Singly_Node<>(value); // Membuat node baru
        if (head == null) { // Mengecek apabila head sudah ada
            head = newNode;
        } else {
            Singly_Node<T> current = head; // Penjelajahan dimulai dari head
            while (current.next != null) { // Melakukan looping sampai current node memiliki next pointer yang null (tail)
                current = current.next; // Mengganti current node dengan node berikutnya
            }
            current.next = newNode; // Menambahkan node baru pada tail
        }
        length++;
    }

    public void addAt(T value, int index) {
        Singly_Node<T> newNode = new Singly_Node<>(value);

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index must be between 0 - length (" + length + ")");
        }

        if (head == null && index == 0) {
            head = newNode;
            length++;
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Singly_Node<T> current = head, next = null;
            for (int i = 0; i < index - 1; i++) {
                assert current != null;
                current = current.next;
                next = current.next;
            }
            newNode.next = next;
            current.next = newNode;

          // Sama-sama mencegah NullPointerException
//            Singly_Node<T> current = head, prev = null;
//            for (int i = 0; i < index; i++) {
//                prev = current;
//                current = current.next;
//            }
//            prev.next = newNode;
//            newNode.next = current;
        }
        length++;
    }

    public T get(int index) {
        Singly_Node<T> desiredNode = head;

        if (index < 0 && index >= length) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return desiredNode.value;
        } else {
            desiredNode = head.next;
            for (int i = 1; i < index; i++) {
                desiredNode = desiredNode.next;
            }
            return desiredNode.value;
        }

    }

    public void display() {
        Singly_Node<T> current = head;
        System.out.println();
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void remove(T value) {
        Singly_Node<T> current = head, prev;

        if (current != null && current.value == value) {
            head = current.next;
            length--;
            return;
        }

        while (current != null) {
            prev = current;
            current = current.next;
            if (current != null) {
                if (current.value.equals(value)) {
                    prev.next = current.next;
                    length--;
                    return;
                }
            } else {
                System.out.println("The value: " + value.toString() + " can't be found!");
            }
        }
    }

}

public class Impl_SinglyLinkedList {

    public static void main(String[] args) {

        MySinglyLinkedList<Integer> singlyLinkedList = new MySinglyLinkedList<>();
//        singlyLinkedList.add(12);
//        singlyLinkedList.add(32);
//        singlyLinkedList.add(46);
//        singlyLinkedList.add(72);
//        singlyLinkedList.add(97);
//        singlyLinkedList.add(24);

        singlyLinkedList.addAt(400, 0);
        singlyLinkedList.display();

//        System.out.println("\nValue of index no.2 -> " + singlyLinkedList.get(2));
//
//        singlyLinkedList.display();
//        singlyLinkedList.remove(46);
//
//        singlyLinkedList.display();
//        singlyLinkedList.remove(1);
//
//        singlyLinkedList.display();
//        singlyLinkedList.addAt(200, 3);
//        singlyLinkedList.display();

    }

}
