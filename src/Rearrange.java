import java.util.*;
class Node1{
    int data;
    Node1 next;
    Node1(int data){
        this.data=data;
        this.next=null;
    }
}
public class Rearrange {
    Node1 head;
    void insert(int data){
        Node1 newnode=new Node1(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node1 temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
    }
    void alternative(){
        Node1 odd=head;
        Node1 even=head.next;
        Node1 evenHead=even;
        while (even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=null;
        Node1 prev=null;
        Node1 curr=evenHead;
        while (curr!=null) {
            Node1 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        odd.next=prev;
    }
    void display(){
        Node1 temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Rearrange r=new Rearrange();
        for (int i=0;i<n;i++){
            int data=s.nextInt();
            r.insert(data);
        }
        r.display();
        System.out.println();
        r.alternative();
        r.display();
        s.close();
    }
}