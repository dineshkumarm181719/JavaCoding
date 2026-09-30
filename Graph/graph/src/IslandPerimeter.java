import java.util.*;
public class IslandPerimeter {
    static int perimeter(int r,int c,int [][]arr){
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]==1){
                    count+=4;
                    if(i>0 && arr[i-1][j]==1){
                        count-=2;
                    }
                    if(j>0 && arr[i][j-1]==1){
                        count-=2;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int r=s.nextInt();
        int c=s.nextInt();
        int [][]arr=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=s.nextInt();
            }
        }
        System.out.println("Island Perimeter: "+perimeter(r,c,arr));
        s.close();
    }
}