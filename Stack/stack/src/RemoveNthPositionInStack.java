import java.util.*;
class Node3{
    int data;
    Node3 next;
    Node3(int data){
        this.data=data;
        this.next=null;
    }
}
public class RemoveNthPositionInStack {
    Node3 top;
    void push(int data){
        Node3 newnode=new Node3(data);
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
            System.out.println("UnderFlow!");
            return -1;
        }
        return top.data;
    }
    boolean isEmpty(){
        return top==null;
    }
    void delete(int pos){
        if(pos==1){
            return;
        }
        Node3 temp=top;
        Node3 prev=temp;
        for (int i=0;i<pos-1;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
    }
    void display(){
        Node3 temp=top;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        RemoveNthPositionInStack r=new RemoveNthPositionInStack();
        for(int i=0;i<n;i++){
            int data=s.nextInt();
            r.push(data);
        }
        r.display();
        int pos=s.nextInt();
        r.delete(pos);
        r.display();
    }
}