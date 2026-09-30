import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class ReverseWordInStack {
    Node top;
    void push(int data){
        Node newnode=new Node(data);
        if(top==null){
            top=newnode;
            return;
        }
        newnode.next=top;
        top=newnode;
    }
    int pop(){
        if(top==null){
            System.out.println("UnderFlow!");
            return -1;
        }
        int removed=top.data;
        top=top.next;
        return removed;
    }
    int peek(){
        if(top==null){
            System.out.println("Underflow!");
            return -1;
        }
        return top.data;
    }
    boolean isEmpty(){
        return top==null;
    }
    void reverse(){
        Node prev=null;
        Node curr=top;
        while (curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        top=prev;
    }
    void display(){
        Node temp=top;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        ReverseWordInStack r=new ReverseWordInStack();
        for(int i=0;i<n;i++){
            int data=s.nextInt();
            r.push(data);
        }
        r.display();
        System.out.println(r.peek());
        System.out.println(r.pop());
        r.display();
        System.out.println(r.isEmpty());
        s.close();
    }
}