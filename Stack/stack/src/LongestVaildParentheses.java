import java.util.*;
class Node6{
    int data;
    Node6 next;
    Node6(int data){
        this.data=data;
        this.next=null;
    }
}
public class LongestVaildParentheses{
    Node6 top;
    void push(int data){
        Node6 newnode=new Node6(data);
        newnode.next=top;
        top=newnode;
    }
    int pop(){
        if(top==null){
            System.out.println("UnderFlow");
            return -1;
        }
        int remove=top.data;
        top=top.next;
        return remove;
    }
    int peek(){
        return top.data;
    }
    boolean isEmpty(){
        return top==null;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        LongestVaildParentheses l=new LongestVaildParentheses();
        l.push(-1);
        int max=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('){
                l.push(ch);
            }
            else{
                l.pop();
                if(l.isEmpty()){
                    l.push(i);
                }
                else{
                    int len=i-l.peek();
                    if(len>max){
                        max=len;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
