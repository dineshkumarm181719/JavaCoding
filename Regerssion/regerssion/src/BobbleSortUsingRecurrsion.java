import java.util.*;
public class BobbleSortUsingRecurrsion {
    static void bobblesort(int arr[],int n){
        if(n==1){
            return;
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                count=count+1;
            }
            if(count==0){
                return;
            }
        }
        bobblesort(arr,n-1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        bobblesort(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}