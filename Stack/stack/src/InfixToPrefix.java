import java.util.*;
import java.util.Stack;
public class InfixToPrefix {
    static int precedence(char ch) {
        if (ch == '^') {
            return 3;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        }
        return -1;
    }
    static String reverse(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '(') {
                rev = rev + ')';
            }
            else if (ch == ')') {
                rev = rev + '(';
            }
            else {
                rev = rev+ch;
            }
        }
        return rev;
    }
    static String convert(String str) {
        str = reverse(str);
        Stack<Character> st = new Stack<>();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                res = res + ch;
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res = res + st.pop();
                }
                st.pop();
            }
            else {
                while (!st.isEmpty()
                        && st.peek() != '('
                        && precedence(st.peek())>precedence(ch)) {
                    res=res + st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            res=res+st.pop();
        }
        String prev = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            prev=prev+res.charAt(i);
        }
        return prev;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println("Prefix : " + convert(str));
        s.close();
    }
}