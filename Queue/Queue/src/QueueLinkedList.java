import java.util.*;
class Node{
    String str;
    Node next;
    Node(String str){
        this.str=str;
        this.next=null;
    }
}
public class QueueLinkedList {
    Node front;
    Node rear;
    void enqueue(String str){
        Node newnode=new Node(str);
        if (rear==null){
            rear=front=newnode;
            return;
        }
        rear.next=newnode;
        rear=newnode;
    }
    void dequeue(){
        if(front==null){
            System.out.println("Queue Is Empty!");
            return;
        }
        System.out.println("dequeue :"+front.str);
        front=front.next;
        if(front==null){
            rear=null;
        }
    }
    void display(){
        Node temp=front;
        while (temp!=null){
            System.out.print(temp.str+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        QueueLinkedList q=new QueueLinkedList();
        int n=s.nextInt();
        int m=s.nextInt();
        s.nextLine();
        for(int i=0;i<m;i++) {
            String str = s.nextLine();
            if (str.equalsIgnoreCase("Enqueue")){
                q.enqueue(s.nextLine());
            }
            if (str.equalsIgnoreCase("Dequeue")){
                q.dequeue();
            }
            if (str.equalsIgnoreCase("Display")){
                q.display();
            }
        }
    }
}