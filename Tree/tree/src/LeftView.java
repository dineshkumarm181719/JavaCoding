import java.util.*;
import java.util.Queue;
class Node1{
    int data;
    Node1 left;
    Node1 right;
    Node1(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class LeftView {
    Node1 root1;
    void insert(int data){
        Node1 newnode = new Node1(data);
        if(root1 == null){
            root1 = newnode;
            return;
        }
        Queue<Node1> q = new LinkedList<>();
        q.add(root1);
        while(!q.isEmpty()){
            Node1 temp = q.poll();

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
    void leftviews(Node1 root1){
        if(root1==null){
            return;
        }
        Queue<Node1> q=new LinkedList<>();
        q.add(root1);
        while (!q.isEmpty()){
            int size=q.size();
            for (int i=0;i<size;i++){
                Node1 curr=q.poll();
                if(i==0){
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
        LeftView l=new LeftView();
        for(int i=0;i<n;i++){
            int data=s.nextInt();
            l.insert(data);
        }
        System.out.println("Left View");
        l.leftviews(l.root1);
    }
}