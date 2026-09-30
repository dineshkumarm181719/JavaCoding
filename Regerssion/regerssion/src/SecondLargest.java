import java.util.*;
public class SecondLargest {
    static int secl(int n,int arr[],int first,int sec,int i){
        if(i==n){
            return sec;
        }
        if(arr[i]>first){
            sec=first;
            first=arr[i];
        }
        else if(arr[i]<first && arr[i]>sec){
            sec=arr[i];
        }
        return secl(n,arr,first,sec,i+1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println(secl(n,arr,Integer.MIN_VALUE,Integer.MIN_VALUE,0));
    }
}