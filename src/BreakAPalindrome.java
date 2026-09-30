import java.util.*;
public class BreakAPalindrome {
    static  String breakpalindrome(String str){
        int n=str.length();
        if(n==1){
            return "";
        }
        char []arr=str.toCharArray();
        for(int i=0;i<n/2;i++){
            if(arr[i]!='a'){
                arr[i]='a';
                return new String(arr);
            }
        }
        arr[n-1]='b';
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        System.out.println(breakpalindrome(str));
    }
}