import java.util.*;
class Node6{
    int data;
    Node6 left,right;
    Node6(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class RecoverBST {
    Node6 root;
    static Node6 insert(Node6 root,int data){
        if(root==null){
            return new Node6(data);
        }
        if(data< root.data){
            root.left=insert(root.left,data);
        }
        if (data> root.data){
            root.right=insert(root.right,data);
        }
        return root;
    }
    static Node6 buildtree(int arr[],int s,int e){
        if(s>  e){
            return null;
        }
        int mid=(s+e)/2;
        Node6 root=new Node6(arr[mid]);
        root.left=buildtree(arr,s,mid-1);
        root.right=buildtree(arr,mid+1,e);
        return root;
    }
    static void inorder(Node6 root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static void levelorder(Node6 root){
        if(root==null){
            return;
        }
        Queue<Node6> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node6 temp=q.poll();
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
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Node6 root = buildtree(arr, 0, n - 1);
        System.out.println("Balanced BST Inorder:");
        inorder(root);
        System.out.println();
        System.out.println("Balanced BST Level Order:");
        levelorder(root);
        s.close();
    }
}