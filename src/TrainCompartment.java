//import java.util.*;
//class Node{
//    int data;
//    Node next;
//    Node(int data){
//        this.data=data;
//        this.next=null;
//    }
//}
//public class TrainCompartment{
//    static Node reversek(Node h,int k){
//        Node t=h;
//        int count=0;
//        while (t!=null && count<k){
//            t=t.next;
//            count++;
//        }
//        if(count<k){
//            return h;
//        }
//        Node prev=null;
//        Node curr=h;
//        for(int i=0;i<k;i++){
//            Node next=curr.next;
//            curr.next=prev;
//            prev=curr;
//            curr=next;
//        }
//        h.next=reversek(curr,k);
//        return prev;
//    }4
//    static void display(Node h){
//        Node t1=h;
//        while (t1!=null){
//            System.out.print(t1.data);
//            if(t1.next!=null){
//                System.out.print("->");
//            }
//            t1=t1.next;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner s=new Scanner(System.in);
//        int n=s.nextInt();
//        Node head = null;
//        Node tail = null;
//        for (int i = 0; i < n; i++) {
//            int value = s.nextInt();
//            Node newNode = new Node(value);
//            if (head == null) {
//                head = newNode;
//                tail = newNode;
//            } else {
//                tail.next = newNode;
//                tail = newNode;
//            }
//        }
//        int k = s.nextInt();
//        head = reversek(head, k);
//        display(head);
//        s.close();
//    }
//}