import java.util.*;
import java.util.Queue;
public class RevealCards{
    static int[]reveal(int []arr,int n){
        Arrays.sort(arr);
        int []ans=new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        for(int i=0;i<n;i++){
            int pos=q.remove();
            ans[pos]=arr[i];
            if(!q.isEmpty()){
                q.add(q.remove());
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int ans[]=reveal(arr,n);
        System.out.print("[");
        for(int i=0;i<n;i++){
            System.out.print(ans[i]);
            if(i<n-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
