import java.util.*;
class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    void insert(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node t=head;
        while (t.next!=null){
            t=t.next;
        }
        t.next=newnode;
    }
    void insertPos(int data,int pos1,int n) {
        Node newnode = new Node(data);
        if (pos1 == 1) {
            newnode.next = head;
            head = newnode;
            return;
        }
        if (pos1-1 >n){
            System.out.println("Invalid Index!");
            return;
        }
        Node t=head;
        Node prev=t;
        for(int i=0;i<pos1-1;i++){
            if(prev==null){
                System.out.println("Out Of Bounds");
                return;
            }
            prev=t;
            t=t.next;
        }
        if(prev==null){
            System.out.println("Out of Bounds");
            return;
        }
        newnode.next=prev.next;
        prev.next=newnode;
    }
    void deletePos(int pos){
        if(head==null){
            return;
        }
        if(pos<0) {
            return;
        }
        Node t=head;
        Node prev=t;
        for (int i=0;i<pos-1;i++){
            prev=t;
            t=t.next;
        }
        prev.next=t.next;
    }
    void display(){
        Node te=head;
        while (te!=null){
            System.out.print(te.data+" ");
            te=te.next;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        LinkedList l=new LinkedList();
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            int data=s.nextInt();
            l.insert(data);
        }
        l.display();
        int pos1=s.nextInt();
        int data1=s.nextInt();
        l.insertPos(data1,pos1,n);
        l.display();
        int pos=s.nextInt();
        l.deletePos(pos);
        l.display();
    }
}