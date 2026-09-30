import java.util.*;
import java.util.Stack;
class  Node1{
    String data;
    Node1 next;
    Node1(String  data){
        this.data=data;
        this.next=null;
    }
}
public class QueueBinary {
    Node1 front;
    Node1 rear;
    void  enqueue(String data){
        Node1 newnode=new Node1(data);
        if(rear==null){
            rear=front=newnode;
            return;
        }
        rear.next=newnode;
        rear=newnode;
    }
    String dequeue() {
        if (front == null) {
            return "";
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
    void display(){
        Node1 temp=front;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        QueueBinary q = new QueueBinary();
        for (int i = 1; i <=n; i++) {
            String current="";
            Stack<Integer> st=new Stack<>();
            int temp=i;
            while (temp>0){
                st.push(temp%2);
                temp=temp/2;
            }
            while (!st.isEmpty()){
                current+=st.pop();
            }
            q.enqueue(current);
        }
        q.display();
        s.close();
    }
}