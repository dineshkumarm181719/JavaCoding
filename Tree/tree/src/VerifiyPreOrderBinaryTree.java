import java.util.*;
class TreeNode1 {
    String str;
    TreeNode1 next;
    TreeNode1(String str) {
        this.str = str;
        this.next = null;
    }
}
public class VerifiyPreOrderBinaryTree {
    static TreeNode1 insert(TreeNode1 root, String str) {
        TreeNode1 newnode = new TreeNode1(str);
        if (root == null) {
            return newnode;
        }
        TreeNode1 temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        return root;
    }
    static boolean isValid(TreeNode1 root) {
        int slot = 1;
        TreeNode1 temp = root;
        while (temp != null) {
            slot--;
            if (slot < 0) {
                return false;
            }
            if (!temp.str.equals("#")) {
                slot += 2;
            }
            temp = temp.next;
        }
        return slot == 0;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] arr = str.split(",");
        TreeNode1 root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i].trim());
        }
        if (isValid(root)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        s.close();
    }
}