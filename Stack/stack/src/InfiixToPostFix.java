import java.util.*;
import java.util.Stack;
public class InfiixToPostFix {
    static int precendence(char ch){
        if(ch=='^'){
            return 3;
        }
        if(ch=='*' || ch=='/'){
            return 2;
        }
        if(ch=='+' || ch=='-'){
            return 1;
        }
        return -1;
    }
    static void convert(String str){
        Stack<Character> st=new Stack<>();
        String res="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                res=res+ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(st.peek()!='('){
                    res=res+st.pop();
                }
                st.pop();
            }
            else{
                while (!st.isEmpty() && st.peek()!='('
                        && precendence(st.peek())>= precendence(ch)){
                    res=res+st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()){
            res=res+st.pop();
        }
        System.out.println("Postfix : "+res);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        convert(str);
    }
}