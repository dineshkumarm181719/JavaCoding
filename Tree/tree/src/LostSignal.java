import java.util.*;
class Node4 {
    int data;
    Node4 left;
    Node4 right;
    Node4(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class LostSignal1 {
    Node4 root;
    void insert(int data) {
        Node4 newnode = new Node4(data);
        if (root == null) {
            root = newnode;
            return;
        }
        Queue<Node4> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node4 temp = q.poll();
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
    static Node4 findtarget(Node4 root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        Node4 left = findtarget(root.left, target);
        if (left != null) {
            return left;
        }
        return findtarget(root.right, target);
    }
    void parent(Node4 root, Map<Node4, Node4> map) {
        if (root == null) {
            return;
        }
        Queue<Node4> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node4 curr = q.poll();
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    void distance(int target, int k) {
        Node4 targetNode = findtarget(root, target);
        if (targetNode == null) {
            System.out.println("Target not found");
            return;
        }
        Map<Node4, Node4> parent = new HashMap<>();
        parent(root, parent);
        Queue<Node4> q = new LinkedList<>();
        Set<Node4> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) {
                while (!q.isEmpty()) {
                    System.out.print(q.remove().data + " ");
                }
                return;
            }
            for (int i = 0; i < size; i++) {
                Node4 current = q.remove();
                if (current.left != null &&
                        !visited.contains(current.left)) {
                    visited.add(current.left);
                    q.add(current.left);
                }
                if (current.right != null &&
                        !visited.contains(current.right)) {
                    visited.add(current.right);
                    q.add(current.right);
                }
                if (parent.containsKey(current)) {
                    Node4 p = parent.get(current);
                    if (!visited.contains(p)) {
                        visited.add(p);
                        q.add(p);
                    }
                }
            }
            distance++;
        }
    }
}
public class LostSignal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LostSignal1 l1 = new LostSignal1();
        for (int i = 0; i < n; i++) {
            int data = s.nextInt();
            l1.insert(data);
        }
        int target = s.nextInt();
        int k = s.nextInt();
        System.out.println("Most K Node Distance: " + k);
        l1.distance(target, k);
        s.close();
    }
}