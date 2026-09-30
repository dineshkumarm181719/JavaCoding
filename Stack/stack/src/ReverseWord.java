import java.io.FilterOutputStream;
import java.util.*;
class Node1{
    char str;
    Node1 next;
    Node1(char str){
        this.str=str;
        this.next=null;
    }
}
public class ReverseWord {
    Node1 top;
    void push(char str){
        Node1 newnode=new Node1(str);
        newnode.next=top;
        top=newnode;
    }
    void pop(){
        if(top==null){
            System.out.println("UnderFlow!");
            return;
        }
        char ch=top.str;
        top=top.next;
        System.out.println(ch);
    }
    void peek(){
        if(top==null){
            System.out.println("UnderFlow!");
            return;
        }
        System.out.println(top.str);
    }
    boolean isEmpty(){
        return top==null;
    }
    void display(){
        Node1 temp=top;
        while (temp!=null){
            System.out.print(temp.str+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        ReverseWord rt=new ReverseWord();
        for(int i=0;i<str.length();i++){
            rt.push(str.charAt(i));
        }
        rt.display();
        s.close();
    }
}