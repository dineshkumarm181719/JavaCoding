import java.util.*;
import java.util.Queue;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class BinaryTree {
    Node root;
    void insert(int data){
        Node newnode = new Node(data);
        if(root == null){
            root = newnode;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();

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
    int level(Node root){
        if(root==null){
            return 0;
        }
        int left1=level(root.left);
        int right1=level(root.right);
        return Math.max(left1,right1)+1;
    }
    int countleaf(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left2=countleaf(root.left);
        int right2=countleaf(root.right);
        return left2+right2;
    }
    int countparent(Node root){
        if(root==null){
            return 0;
        }
        if(root.left!=null && root.right!=null) {
            return 1 + countparent(root.left)+countparent(root.right);
        }
        return 0;
    }
    int findDepth(Node root,int value,int depth){
        if(root==null){
            return -1;
        }
        if(root.data==value){
            return depth;
        }
        int left4=findDepth(root.left,value,depth+1);
        if(left4!=-1){
            return left4;
        }
        return findDepth(root.right,value,depth+1);
    }
    int height(Node root){
        if(root==null){
            return 0;
        }
        int left3=height(root.left);
        int right3=height(root.right);
        return Math.max(left3,right3)+1;
    }
    void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    int countSiblings(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        if(root.left!=null && root.right!=null){
            count=1;
        }
        return count+countSiblings(root.left)+countSiblings(root.right);
    }
    void bfs(){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node temp=q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        BinaryTree b=new BinaryTree();
        for (int i=0;i<n;i++){
            int data=s.nextInt();
            b.insert(data);
        }
        System.out.println("Inorder Traversal");
        b.inorder(b.root);
        System.out.println();
        int res=b.level(b.root);
        System.out.println("Level: "+res);
        int res1= b.countleaf(b.root);
        System.out.println("Count Leaf: "+res1);
        int res3=b.countparent(b.root);
        System.out.println("Count Parent: "+res3);
        int res4=b.height(b.root);
        System.out.println("Height: "+res4);
        int res5= b.findDepth(b.root,50,0);
        System.out.println("Depth: "+res5);
        int res6=b.countSiblings(b.root);
        System.out.println("Count Siblings Pairs: "+res6);
        System.out.println("Preorder Traversal");
        b.preorder(b.root);
        System.out.println();
        System.out.println("Postorder Traversal");
        b.postorder(b.root);
        System.out.println();
        System.out.println("BFS");
        b.bfs();
        s.close();
    }
}