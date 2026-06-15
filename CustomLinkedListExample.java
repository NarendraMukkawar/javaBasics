public class CustomLinkedListExample {

    // Node class
    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    // Add element at the end, it is a singly linkedlist
    public void add(int data) {

        Node newNode = new Node(data);

        // First time checking if head is null then assigning first element to headnode
        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            // Traversing till last node because headnode is non empty and we are adding
            // elements at the end
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        size++;
    }

    // Display elements
    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // no need to traverse as we are storing size it in data member
    public int size() {
        return size;
    }

    // remove by value
    public void remove(int value) {

        // check empty list
        if (head == null) {
            return;
        }

        // Remove head
        if (head.data == value) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.data == value) { // here we doing temp.next.data not temp.data as we need to next elements
                                           // address in
                // previous one if value matches
                temp.next = temp.next.next;
                size--;
                return;
            }

            temp = temp.next;
        }
    }

    // Check element present
    public boolean contains(int value) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == value) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {

        CustomLinkedListExample list = new CustomLinkedListExample();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.display();

        System.out.println("Size :- " + list.size());

        System.out.println("Contains 20 :- " + list.contains(20));

        list.remove(20);

        list.display();

        System.out.println("Size :- " + list.size());
    }
}