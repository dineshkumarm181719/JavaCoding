import java.util.*;
public class IslandsNoFriendship {
    static int n;
    static  int [][]arr;
    static boolean[]visited;
    static void dfs(int p){
        visited[p]=true;
        for (int i=0;i<n;i++){
            if(arr[p][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        arr=new  int[n][n];
        visited=new boolean[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                arr[i][j]=s.nextInt();
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}