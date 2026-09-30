import java.util.*;
class Node5 {
    int data;
    Node5 left;
    Node5 right;
    Node5(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryStree {
    boolean isBst;
    int size;
    int min;
    int max;
    BinaryStree(boolean isBst, int size, int min, int max) {
        this.isBst = isBst;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}
public class LargestBstUsingBinaryTree {
    static Node5 root;
    static int largest = 0;
    static void insert(int data) {
        Node5 newnode = new Node5(data);
        if (root == null) {
            root = newnode;
            return;
        }
        Queue<Node5> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node5 temp = q.poll();
            if (temp.left == null) {
                temp.left = newnode;
                return;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newnode;
                return;
            } else {
                q.add(temp.right);
            }
        }
    }
    static BinaryStree largestbst(Node5 root) {
        if (root == null) {
            return new BinaryStree(
                    true,
                    0,
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE
            );
        }
        BinaryStree left = largestbst(root.left);
        BinaryStree right = largestbst(root.right);
        if (left.isBst &&
                right.isBst &&
                root.data > left.max &&
                root.data < right.min) {
            int size = left.size + right.size + 1;
            if (size > largest) {
                largest = size;
            }
            int min = root.data;
            if (left.min < min) {
                min = left.min;
            }
            int max = root.data;
            if (right.max > max) {
                max = right.max;
            }
            return new BinaryStree(true, size, min, max);
        }
        return new BinaryStree(false, 0, 0, 0);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int data = s.nextInt();
            insert(data);
        }
        largestbst(root);
        System.out.println("Largest BST size: " + largest);
    }
}