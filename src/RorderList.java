import java.util.*;
class Node2{
    int data;
    Node2 next;
    Node2(int data){
        this.data=data;
        this.next=null;
    }
}
public class RorderList {
    Node2 head;
    void insert(int data){
        Node2 newnode=new Node2(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node2 temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
    }
    void reorderlist(){
        if(head==null || head.next==null){
            return;
        }
        Node2 slow=head;
        Node2 fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node2 second=slow.next;
        slow.next=null;
        Node2 prev=null;
        while (second!=null){
            Node2 next=second.next;
            second.next=prev;
            prev=second;
            second=next;
        }
        second=prev;
        Node2 first=head;
        while(second !=null){
            Node2 t1=first.next;
            Node2 t2=second.next;
            first.next=second;
            second.next=t1;
            first=t1;
            second=t2;
        }
    }
    void display(){
        Node2 temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        RorderList r=new RorderList();
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            int data=s.nextInt();
            r.insert(data);
        }
        r.display();
        System.out.println();
        r.reorderlist();
        r.display();
        s.close();
    }
}