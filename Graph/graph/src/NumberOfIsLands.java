import java.util.*;
public class NumberOfIsLands {
    static int [][]arr;
    static int rows,cols;
    static void dfs(int r,int c){
        arr[r][c]=0;
        int [] d={-1,0,1,0,-1};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int newrow=r+d[i];
                int newcol=c+d[i+1];
                if(newrow>=0 && newrow <rows && newcol>=0 && newcol <cols && arr[newrow][newcol]==1){
                    dfs(newrow,newcol);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        rows =s.nextInt();
        cols=s.nextInt();
        arr=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                arr[i][j]=s.nextInt();
            }
        }
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(arr[i][j]==1){
                    dfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}