//import java.util.*;
//class Node4 {
//    int data;
//    Node4 next;
//
//    Node4(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//public class NextStrongSignal {
//    Node4 head;
//    void insert(int data) {
//        Node4 newnode = new Node4(data);
//        if (head == null) {
//            head = newnode;
//            return;
//        }
//        Node4 temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = newnode;
//    }
//    void nextstrong() {
//        Stack<Integer> st = new Stack<>();
//        Node4 temp = head;
//        int n = 0;
//        while (temp != null) {
//            n++;
//            temp = temp.next;
//        }
//        int arr[] = new int[n];
//        temp = head;
//        for (int i = 0; i < n; i++) {
//            arr[i] = temp.data;
//            temp = temp.next;
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            int curr = arr[i];
//            while (!st.isEmpty() && st.peek() <= curr) {
//                st.pop();
//            }
//            if (st.isEmpty()) {
//                arr[i] = 0;
//            } else {
//                arr[i] = st.peek();
//            }
//
//            st.push(curr);
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//    void display() {
//        Node4 temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int m = s.nextInt();
//        NextStrongSignal ns = new NextStrongSignal();
//        for (int i = 0; i < m; i++) {
//            int data = s.nextInt();
//            ns.insert(data);
//        }
//        ns.display();
//        ns.nextstrong();
//        s.close();
//    }
//}