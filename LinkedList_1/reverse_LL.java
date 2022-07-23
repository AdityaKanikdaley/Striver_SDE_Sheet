package LinkedList_1;

public class reverse_LL {
    public static void main(String[] args) {
            MyLL_reverse_LL list = new MyLL_reverse_LL();
            for(int i=1; i<=10; i++)
                list.add(i);

            list.print();
            System.out.println();
            list.reverse();
    }
}

class MyLL_reverse_LL {

    Node head;

    void reverse() {
        Node prev = null;
        Node cur = head;
        Node temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }

        //print reverse list
        Node prevTemp = prev;
        while (prevTemp != null) {
            System.out.print(prevTemp.data + " ");
            prevTemp = prevTemp.next;
        }
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
