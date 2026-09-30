import java.util.*;
public class StringPalindrome {
    static boolean revs(String str,int i,int j){
        if(i>j){
            return true;
        }
        if(str.charAt(i)!=str.charAt(j)){
            return false;
        }
        return revs(str,i+1,j-1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        boolean res=revs(str,0,str.length()-1);
        System.out.println(res);
        s.close();
    }
}