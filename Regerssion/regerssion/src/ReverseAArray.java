import java.util.*;
public class ReverseAArray {
    static void rev(int n,int arr[],int i){
        if(i==n){
            return ;
        }
        rev(n,arr,i+1);
        System.out.print(arr[i]+" ");
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        rev(n,arr,0);
    }
}