import java.util.*;
public class PrintAllSubsquence {
    static void subsequence(int arr[],int i,ArrayList<Integer>list){
        if (i==arr.length){
            System.out.println(list);
            return;
        }
        subsequence(arr,i+1,list);
        list.add(arr[i]);
        subsequence(arr,i+1,list);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        ArrayList<Integer>list=new ArrayList<>();
        subsequence(arr,0,list);
    }
}