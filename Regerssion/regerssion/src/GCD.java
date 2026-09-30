import java.util.*;
public class GCD {
    static int gcd(int n,int m){
        if(m==0){
            return n;
        }
        return gcd(m,n%m);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int res=gcd(n,m);
        System.out.println(res);
        s.close();
    }
}