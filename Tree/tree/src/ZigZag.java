import java.util.*;
import java.util.ArrayList;
class Node3{
    int data;
    Node3 left;
    Node3 right;
    Node3(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class ZigZag {
    Node3 root;
    void insert(int data){
        Node3 newnode = new Node3(data);
        if(root == null){
            root = newnode;
            return;
        }
        Queue<Node3> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node3 temp = q.poll();

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
    static int height(Node3 root){
        if(root==null){
            return 0;
        }
        int left3=height(root.left);
        int right3=height(root.right);
        return Math.max(left3,right3)+1;
    }
   static void lefttoright(Node3 root,int level,ArrayList<Integer>res){
        if(root==null){
            return;
        }
        if(level==1){
            res.add(root.data);
        }
        else{
            lefttoright(root.left,level-1,res);
            lefttoright(root.right,level-1,res);
        }
    }
   static void righttoleft(Node3 root,int level,ArrayList<Integer>res){
        if (root==null){
            return;
        }
        if(level==1){
            res.add(root.data);
        }
        else {
            righttoleft(root.right,level-1,res);;
            righttoleft(root.left,level-1,res);
        }
    }
    static ArrayList<Integer> zigZagTraversal(Node3 root){
        ArrayList<Integer>res=new ArrayList<>();
        int h=height(root);
        boolean lefttoright=true;
        for (int i=1;i<=h;i++){
            if(lefttoright){
                lefttoright(root,i,res);
            }
            else{
                righttoleft(root,i,res);
            }
            lefttoright=!lefttoright;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        ZigZag z=new ZigZag();
        for(int i=0;i<n;i++){
            int data=s.nextInt();
            z.insert(data);
        }
        ArrayList<Integer> result = zigZagTraversal(z.root);
        System.out.println("ZigZag Traversal:");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}