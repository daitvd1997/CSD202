/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 * code debt : ham sort chua hoan thanh
 * @author Trinh Dai
 * @param <T>
 */
public class SinglyLinkedList<T> {

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    //insert 1 object type T to head linkedkist
    public void insertToHead(T x) {
        Node pNode = new Node(x);
        if (head == null) {
            head = pNode;
            tail = pNode;
            return;
        }
        pNode.next = head;
        head = pNode;
    }

    
    //insert 1 object type T to tail linkedkist
    public void inserToTail(T x) {
        Node pNode = new Node(x);
        if (isEmpty()) {
            head = pNode;
            tail = pNode;
            return;
        }
        tail.next = pNode;
        tail = pNode;
    }

    public void traverse() {
        Node pNode = head;
        while (pNode != null) {
            System.out.println(pNode.data);
            pNode = pNode.next;
        }
    }

    //inset 1 object to other node
    public void inserAfterQ(Node qNode, T x) {
        if (qNode != null) {
            Node pNode = new Node(x);
            pNode.next = qNode.next;
            qNode.next = pNode;
        }
    }

    //delete 1 object head
    public void deleteAtHead() {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            System.out.println("Successfully deleted");
        }
        head = head.next;
        System.out.println("Successfully deleted");
    }

    //delete tail
    public void deleteAtTail() {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            System.out.println("Successfully deleted");
        }
        Node p = head;
        while (p.next != tail) {
            p = p.next;
        }
        tail = p;
        tail.next = null;
        System.out.println("Successfully deleted");
    }

    
    // search linkedlist by data object
    public Node searchNode(T x) {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return null;
        }
        Node pNode = head;
        while (pNode != null) {
            if (pNode.data == x) {
                System.out.println("Found node data = " + x);
                return pNode;
            }
            pNode = pNode.next;
        }
        System.out.println("Not Found !! data = " + x);
        return null;
    }

    
//    delete 1 object
    public void deleteAfterQ(Node qNode) {
        if (qNode == tail) {
            System.out.println("Can't not delete node. Cause it's tail");
            return;
        }
        if (qNode != null) {
            qNode.next = qNode.next.next;
            System.out.println("Successfully deteted");
            return;
        }
    }

    public void deleteNodebyValue(T x) {
        Node pNode = searchNode(x);
        if (pNode == null) {
            return;
        }
        if (pNode == head) {
            deleteAtHead();
            return;
        }
        Node qNode = head;
        while (qNode.next != pNode) {
            qNode = qNode.next;
        }
        qNode.next = pNode.next;
        pNode.next = null;
        System.out.println("Successlly deleted");
    }

    public int countNode() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void delateNode(Node pNode) {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }
        if (pNode == tail) {
            deleteAtTail();
            return;
        }
        if (pNode == head) {
            deleteAtHead();
            return;
        }
        Node qNode = head;
        while (qNode.next != pNode) {
            qNode = qNode.next;
        }
        qNode.next = pNode.next;
        pNode.next = null;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index > countNode()) {
            System.out.println("Can't delete. Out of bounds");
        }
        int temp = 0;
        Node pNode = head;
        while (pNode != null) {
            if (index == temp) {
                delateNode(pNode);
            }
        }
    }

//    public void sortNode() {
//        if (isEmpty()) {
//            System.out.println("Linked list is empty");
//            return;
//        }
//        if (head == tail) {
//            return;
//        }
//        Node qNode = head;
//        Node kNode = qNode.next;
//        while (qNode.next != null) {
//            while (kNode != null) {
//                if (qNode.data > kNode.data) {
//                    int temp = qNode.data;
//                    qNode.data = kNode.data;
//                    kNode.data = temp;
//                }
//                kNode = kNode.next;
//            }
//            qNode = qNode.next;
//            kNode = qNode.next;
//        }
//    }
    
//    public int[] toArray() {
//        if (isEmpty()) {
//            System.out.println("Linked list is empty");
//            return null;
//        }
//        int[] array = new int[countNode()];
//        Node pNode = head;
//        T index = null;
//        while(pNode != null) {
//            array[index] = pNode.data;
//            pNode = pNode.next;
//        }
//        return array;
//    }
    
    public void insertBeforeNode(Node pNode, T x) {
        Node qNode = new Node(x);
        if(pNode != null) {
           qNode.next = pNode.next;
           pNode.next = qNode;
        }
    }
    
    public void deleteAllNodeWithValue(T x) {
        Node pNode = head;
        while(pNode != null) {
            if(pNode.data == x) {
                delateNode(pNode);
                pNode = head;
            }
            pNode = pNode.next;
        }
    }
}
