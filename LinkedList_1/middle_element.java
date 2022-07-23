package LinkedList_1;

public class middle_element {
    public static void main(String[] args) {
            MyLL_middle_element list = new MyLL_middle_element();
            for(int i=1; i<=9; i++)
                list.add(i);

            list.print();
            System.out.println();
            list.middleElement();
    }
}

class MyLL_middle_element {
    Node head;
    
    void middleElement() {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println("Middle element: " + slow.data);
    }
    void add(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = new Node(data);
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
