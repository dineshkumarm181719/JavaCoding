import java.util.*;
public class Print1ToN {
    static void rev(int n,int i){
        if(i==n+1){
            return;
        }
        System.out.print(i+" ");
         rev(n,i+1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        rev(n,1);
    }
}