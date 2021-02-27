import javax.xml.soap.Node;

public class MyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int numNodes = 0;

    public MyLinkedList(Object data){
        head = new Node(data);
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object e) {
        Node newNode = new Node(e); // Create a new node for e

        if (tail == null) {
            head = tail = newNode; // The only node in list
        }
        else {
            tail.next = newNode; // Link the new node with the last node
            tail = tail.next; // tail now points to the last node
        }

        numNodes++; // Increase size
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index-1 && temp.next !=null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public Object removeFirst() {
        if (numNodes == 0) return null; // Nothing to delete
        else {
            Node temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            numNodes--; // Reduce size by 1
            if (head == null) tail = null; // List becomes empty
            return temp.data; // Return the deleted element
        }
    }

    public Object removeLast() {
        if (numNodes == 0) return null; // Nothing to remove
        else if (numNodes == 1) { // Only one element in the list
            Node temp = head;
            head = tail = null; // list becomes empty
            numNodes = 0;
            return temp.data;
        } else {
            Node current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return temp.data;
        }
    }

    public Object remove(int index) {
        if (index < 0 || index >= numNodes) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == numNodes - 1) return removeLast(); // Remove last
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return current.data;
        }
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private class Node{
        private Node next;
        private Object data;


        public Node(Object data) {
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }

        public Node get(int index){
            Node temp=head;
            for(int i=0; i<index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }
}
