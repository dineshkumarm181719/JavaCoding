import java.util.*;
class Node7{
    int data;
    Node7 next;
    Node7(int data){
        this.data=data;
        this.next=null;
    }
}
class Stack{
    Node7 top;
    void push(int data){
        Node7 newNode=new Node7(data);
        newNode.next=top;
        top=newNode;
    }
    int pop(){
        int data=top.data;
        top=top.next;
        return data;
    }
    int peek(){
        return top.data;
    }
    boolean isEmpty(){
        return top==null;
    }
}
public class Solution{
    int precedence(char ch){
        if(ch=='+'||ch=='-'){
            return 1;
        }
        if(ch=='*'||ch=='/'){
            return 2;
        }
        if(ch=='^'){
            return 3;
        }
        return 0;
    }
    int calculate(int a,int b,char op){
        if(op=='+'){
            return a+b;
        }
        if(op=='-'){
            return a-b;
        }
        if(op=='*'){
            return a*b;
        }
        if(op=='/'){
            return a/b;
        }
        if(op=='^'){
            return (int)Math.pow(a,b);
        }
        return 0;
    }
    int evaluate(String expression){
        Stack operators = new Stack();
        Stack numbers = new Stack();
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch==' '){
                continue;
            }
            if(ch>='0'&&ch<='9'){
                numbers.push(ch-'0');
            }
            else if(ch=='('){
                operators.push(ch);
            }
            else if(ch==')'){
                while(!operators.isEmpty()&&operators.peek()!='('){
                    char op=(char)operators.pop();
                    int b=numbers.pop();
                    int a=numbers.pop();
                    int result=calculate(a,b,op);
                    numbers.push(result);
                }
                operators.pop();
            }
            else{
                while(!operators.isEmpty()&&operators.peek()!='('&&precedence((char)
                        operators.peek())>=precedence(ch)){
                    char op=(char)operators.pop();
                    int b=numbers.pop();
                    int a=numbers.pop();
                    int result=calculate(a,b,op);
                    numbers.push(result);
                }
                operators.push(ch);
            }
        }
        while(!operators.isEmpty()){
            char op=(char)operators.pop();
            int b=numbers.pop();
            int a=numbers.pop();
            int result=calculate(a,b,op);
            numbers.push(result);
        }
        return numbers.pop();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter expression:");
        String expression=sc.nextLine();
        Solution obj=new Solution();
        int result=obj.evaluate(expression);
        System.out.println("Result: "+result);
        sc.close();
    }
}