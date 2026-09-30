import java.util.*;
class TNode {
    int data;
    TNode left, right;
    TNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class MirrorTree1 {
    TNode root;
    public void Create(int arr[]) {
        if (arr.length == 0 || arr[0] == -1) {
            return;
        }
        root = new TNode(arr[0]);
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TNode current = q.poll();
            if (i < arr.length && arr[i] != -1) {
                current.left = new TNode(arr[i]);
                q.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                current.right = new TNode(arr[i]);
                q.add(current.right);
            }
            i++;
        }
    }
    public boolean isSymmetric() {
        if (root == null) {
            return true;
        }
        Queue<TNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TNode left = q.poll();
            TNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.data != right.data) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
public class MirrorTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MirrorTree1 t = new MirrorTree1();
        t.Create(arr);
        System.out.println(t.isSymmetric());
    }
}
