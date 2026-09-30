import java.util.*;
public class ReverseAString {
    static String revs(String str,int i,int j){
        if(i>j){
            return str;
        }
        return revs(swap(str.toCharArray(),i,j),i+1,j-1);
    }
    static String swap(char []ch,int i,int j){
        char c=ch[i];
        ch[i]=ch[j];
        ch[j]=c;
        return new String(ch);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        String res=revs(str,0,str.length()-1);
        System.out.println(res);
    }
}