import java.util.*;
public class SecondLargestElement {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int first=0;
        int second=0;
        for(int i=0;i<n;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }
            else if(arr[i]<first && arr[i]>second) {
                second = arr[i];
            }
        }
        System.out.println(first);
        System.out.println(second);
        s.close();
    }
}