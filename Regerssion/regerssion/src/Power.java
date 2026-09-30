import java.util.*;
public class Power {
    static long power(int base,int pow){
        if(pow==0){
            return 1;
        }
        return base*power(base,pow-1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int base=s.nextInt();
        int pow=s.nextInt();
        long res=power(base,pow);
        System.out.println(res);
        s.close();
    }
}