import java.util.*;
class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MergeTwoSortedList {
    static Node3 insert(Node3 head, int data) {
        Node3 newnode = new Node3(data);
        if (head == null) {
            return newnode;
        }
        Node3 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        return head;
    }
    static Node3 merge(Node3 head, Node3 head2) {
        Node3 dummy = new Node3(-1);
        Node3 curr = dummy;
        if (head == null) {
            return head2;
        }
        if (head2 == null) {
            return head;
        }
        while (head != null && head2 != null) {
            if (head.data > head2.data) {
                curr.next = head2;
                head2 = head2.next;
            }
            else {
                curr.next = head;
                head = head.next;
            }
            curr = curr.next;
        }
        curr.next = (head != null) ? head : head2;
        return dummy.next;
    }
    static void display(Node3 head) {
        Node3 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MergeTwoSortedList m = new MergeTwoSortedList();
        Node3 head = null;
        Node3 head2 = null;
        int n1 = s.nextInt();
        for (int i = 0; i < n1; i++) {
            int data = s.nextInt();
            head = m.insert(head, data);
        }
        int n2 = s.nextInt();
        for (int i = 0; i < n2; i++) {
            int data1 = s.nextInt();
            head2 = m.insert(head2, data1);
        }
        m.display(head);
        m.display(head2);
        Node3 res = merge(head, head2);
        m.display(res);
    }
}