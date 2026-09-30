import java.util.*;
public class ReverseANumber {
    static int revs(int n,int rev1){
        if(n==0){
            return rev1;
        }
        int digit=n%10;
        return revs(n/10,rev1*10+digit);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int res=revs(n,0);
        System.out.println(res);
        s.close();
    }
}