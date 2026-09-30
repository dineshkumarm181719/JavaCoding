import java.util.*;
class Node2{
    String str;
    Node2 next;
    Node2(String str){
        this.str=str;
        this.next=null;
    }
}
public class ReverseSentenceUsingStack {
    Node2 top;
    void push(String str){
        Node2 newnode=new Node2(str);
        newnode.next=top;
        top=newnode;
    }
    void pop(){
        if(top==null){
            System.out.println("Underflow");
            return;
        }
        System.out.print(top.str+" ");
        top=top.next;
    }
    void peek(){
        if(top==null){
            System.out.println("UnderFlow");
            return;
        }
        System.out.print(top.str);
    }
    void display(){
        Node2 temp=top;
        while (temp!=null){
            System.out.print(temp.str+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        ReverseSentenceUsingStack rt=new ReverseSentenceUsingStack();
        String res="";
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch!=' '){
                res=res+ch;
            }
            else {
                rt.push(res);
                res="";
            }
        }
        rt.push(res);
        rt.display();
        s.close();
    }
}