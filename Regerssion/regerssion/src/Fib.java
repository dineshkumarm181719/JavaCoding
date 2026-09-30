import java.util.*;
public class Fib {
    static int fibs(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibs(n-1)+fibs(n-2);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++) {
            int res = fibs(i);
            System.out.println(res);
        }
        s.close();
    }
}