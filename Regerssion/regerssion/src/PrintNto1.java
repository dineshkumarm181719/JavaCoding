import java.util.*;
public class PrintNto1 {
    static void rev(int n,int i){
        if(i==n+1){
            return;
        }
        rev(n,i+1);
        System.out.print(i+" ");
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        rev(n,1);
    }
}