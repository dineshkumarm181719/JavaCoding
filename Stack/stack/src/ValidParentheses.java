import java.util.*;
class Node5{
    char data;
    Node5 next;
    Node5(char data){
        this.data=data;
        this.next=null;
    }
}
public class ValidParentheses {
    Node5 top;
    void push(char data){
        Node5 newnode=new Node5(data);
        newnode.next=top;
        top=newnode;
    }
    char pop(){
        char remove=top.data;
        top=top.next;
        return remove;
    }
    boolean isEmpty(){
        return top==null;
    }
    boolean valid(String str){
        int n=str.length();
        for (int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch=='('|| ch=='{' || ch=='['){
                push(ch);
            }
            else{
                if(top==null){
                    return false;
                }
                char x=pop();
                if(ch==')' && x!='('){
                    return false;
                }
                if(ch=='}' && x!='{'){
                    return false;
                }
                if(ch==']' && x!='['){
                    return false;
                }
            }
        }
        if(top==null){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String  str=s.nextLine();
        ValidParentheses v=new ValidParentheses();
        if(v.valid(str)){
            System.out.println("Valid");
        }
        else{
            System.out.println("Not Valid!");
        }
        s.close();
    }
}