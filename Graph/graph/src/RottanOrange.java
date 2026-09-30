import java.util.*;
import java.util.LinkedList;
public class RottanOrange {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int rows=s.nextInt();
        int cols=s.nextInt();
        int [][]arr=new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                arr[i][j]=s.nextInt();
            }
        }
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(arr[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(arr[i][j]==1){
                    fresh++;
                }
            }
        }
        int minutes=0;
        int [][] dit={{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty() && fresh>0){
            int size=q.size();
            for (int i=0;i<size;i++){
                int []curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int []d:dit){
                    int newr=r+d[0];
                    int newc=c+d[1];
                    if(newr>=0 && newr<rows && newc>=0 && newc<cols && arr[newr][newc]==1){
                        arr[newr][newc]=2;
                        fresh--;
                        q.offer(new int[]{newr, newc});
                    }
                }
            }
            minutes++;
        }
        if(fresh==0){
            System.out.println(minutes);
        }
        else{
            System.out.println("-1");
        }
    }
}