import java.util.*;
public class LargestNumberInADigit {
    static int rev(int n,int max){
        if(n<=0){
            return max;
        }
        max=Math.max(max,n%10);
        return rev(n/10,max);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int res=rev(n,0);
        System.out.println(res);
        s.close();
    }
}