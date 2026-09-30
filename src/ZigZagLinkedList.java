//import java.util.*;
//class  Node{
//    int data;
//    Node next;
//    Node(int data){
//        this.data=data;
//        this.next=null;
//    }
//}
//public class ZigZagLinkedList {
//    static Node zigzags(Node h1,Node h2){
//        Node dummy=new Node(0);
//        Node temp=dummy;
//        while (h1!=null && h2!=null){
//            temp.next=h1;
//            temp=temp.next;
//            h1=h1.next;
//
//            temp.next=h2;
//            temp=temp.next;
//            h2=h2.next;
//        }
//        while (h1!=null){
//            temp.next=h1;
//            temp=temp.next;
//            h1=h1.next;
//        }
//        while (h2!=null){
//            temp.next=h2;
//            temp=temp.next;
//            h2=h2.next;
//        }
//        return dummy.next;
//    }
//    static void printlist(Node head){
//        Node t=head;
//        while (t!=null){
//            System.out.print(t.data+" ");
//            t=t.next;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner s=new Scanner(System.in);
//        int n1=s.nextInt();
//        Node head1 = null;
//        Node tail1 = null;
//        for (int i = 0; i < n1; i++) {
//            int value = s.nextInt();
//            Node newNode = new Node(value);
//            if (head1 == null) {
//                head1 = newNode;
//                tail1 = newNode;
//            } else {
//                tail1.next = newNode;
//                tail1 = newNode;
//            }
//        }
//        int n2=s.nextInt();
//        Node head2 = null;
//        Node tail2 = null;
//        for (int i = 0; i < n2; i++) {
//            int value = s.nextInt();
//            Node newNode = new Node(value);
//            if (head2 == null) {
//                head2 = newNode;
//                tail2 = newNode;
//            } else {
//                tail2.next = newNode;
//                tail2 = newNode;
//            }
//        }
//        Node result = zigzags(head1, head2);
//        printlist(result);
//        s.close();
//    }
//}