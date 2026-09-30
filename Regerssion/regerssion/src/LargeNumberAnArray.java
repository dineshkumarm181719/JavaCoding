import java.util.*;
public class LargeNumberAnArray{
    static int large(int n,int arr[],int max,int i){
        if(i==n){
            return max;
        }
        if(arr[i]>max){
            max=arr[i];
        }
        return large(n,arr,max,i+1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println(large(n,arr,Integer.MIN_VALUE,0));
    }
}