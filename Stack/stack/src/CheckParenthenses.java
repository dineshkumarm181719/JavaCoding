import java.util.*;
import java.util.Stack;
public class CheckParenthenses {
    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        boolean expectOperand = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                if (!expectOperand) {
                    return false;
                }
                expectOperand = false;
            }
            else if (ch == '(') {
                if (!expectOperand) {
                    return false;
                }
                stack.push(ch);
                expectOperand = true;
            }
            else if (ch == ')') {
                if (expectOperand) {
                    return false;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                if (i >= 2 && str.charAt(i - 2) == '(') {
                    return false;
                }
                expectOperand = false;
            }
            else if (ch == '+' || ch == '-' ||
                    ch == '*' || ch == '/') {

                if (expectOperand) {
                    return false;
                }
                expectOperand = true;
            }
            else if (ch != ' ') {
                return false;
            }
        }
        if (expectOperand) {
            return false;
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (isValid(str)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        sc.close();
    }
}