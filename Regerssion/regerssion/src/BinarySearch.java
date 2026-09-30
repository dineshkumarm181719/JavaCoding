import java.util.*;
public class BinarySearch {
    static int search(int arr[],int i,int j,int k){
        if(i>j){
            return -1;
        }
        int mid=i+(j+i)/2;
        if(arr[mid]==k){
            return mid;
        }
        if(k<arr[mid]){
            return search(arr,i,mid-1,k);
        }
        return search(arr,mid+1,j,k);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int k=s.nextInt();
        int res=search(arr,0,n-1,k);
        if(res==-1){
            System.out.println("Element Not Found!");
        }
        else{
            System.out.println("Element Is Found: "+res);
        }
        s.close();
    }
}