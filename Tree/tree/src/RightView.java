import java.util.*;
import java.util.Queue;
class Node2{
    int data;
    Node2 left;
    Node2 right;
    Node2(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class RightView {
    Node2 root1;
    void insert(int data){
        Node2 newnode = new Node2(data);
        if(root1 == null){
            root1 = newnode;
            return;
        }
        Queue<Node2> q = new LinkedList<>();
        q.add(root1);
        while(!q.isEmpty()){
            Node2 temp = q.poll();

            if(temp.left == null){
                temp.left = newnode;
                return;
            } else {
                q.add(temp.left);
            }
            if(temp.right == null){
                temp.right = newnode;
                return;
            } else {
                q.add(temp.right);
            }
        }
    }
    void rightview(Node2 root1){
        if(root1==null){
            return;
        }
        Queue<Node2> q=new LinkedList<>();
        q.add(root1);
        while (!q.isEmpty()){
            int size=q.size();
            for (int i=0;i<size;i++){
                Node2 curr=q.poll();
                if(i==size-1){
                    System.out.print(curr.data+" ");
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        RightView r=new RightView();
        for (int i=0;i<n;i++){
            int data=s.nextInt();
            r.insert(data);
        }
        System.out.println("Right View");
        r.rightview(r.root1);
    }
}