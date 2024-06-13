package LinkedList;

class Doubly_Node<T> {
    T value;
    Doubly_Node<T> next;
    Doubly_Node<T> prev;

    public Doubly_Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class MyDoublyLinkedList<T> {
    Doubly_Node<T> head;
    Doubly_Node<T> tail;
    int length;

    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void add(T value) {
        Doubly_Node<T> newNode = new Doubly_Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Doubly_Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        }
        length++;
    }

    public void addAt(T value, int index) {
        Doubly_Node<T> newNode = new Doubly_Node<>(value);

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index must be between 0 - length (" + length + ")");
        }

        if (head == null && index == 0) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }

        if (index == length) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Doubly_Node<T> current;
            if (index <= length / 2 - 1) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            } else {
                current = tail;
                for (int i = length - 1; i > index; i--) {
                    current = current.prev;
                }
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        length++;
    }

    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index must be between 0 - " + (length - 1));
        }

        Doubly_Node<T> current;
        if (index <= length / 2 - 1) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.prev;
            }
            return current.value;
        }
    }

    public void display() {
        Doubly_Node<T> current = head;
        System.out.print("null <-> ");
        while (current != null) {
            System.out.print(current.value + " <-> ");
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        System.out.println("null\n");
    }
}

public class Impl_DoublyLinkedList {

    public static void main(String[] args) {

        MyDoublyLinkedList<Integer> doublyLinkedList = new MyDoublyLinkedList<>();

        doublyLinkedList.add(10);
        doublyLinkedList.add(20);
        doublyLinkedList.add(30);
        doublyLinkedList.add(40);
        doublyLinkedList.add(50);
        doublyLinkedList.add(60);
        doublyLinkedList.add(70);

        doublyLinkedList.display();
        doublyLinkedList.addAt(1000, 3);
        doublyLinkedList.display();

        System.out.println(doublyLinkedList.get(7));

    }

}
