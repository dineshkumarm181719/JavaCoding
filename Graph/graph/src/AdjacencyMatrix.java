import java.util.*;
public class AdjacencyMatrix {
    static void graph(int[][]arr,int u,int v){
        arr[u][v]=1;
        arr[v][u]=1;
    }
    static void printgraph(int arr[][],int n){
        for(int i=0;i<n;i++){
            System.out.print((i+1)+"->");
            boolean first=true;
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    if(!first){
                        System.out.print(",");
                    }
                    System.out.print(j+1);
                    first=false;
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int [][]arr=new int[n][n];
        System.out.println("Enter the Edges: ");
        int e=s.nextInt();
        for(int i=0;i<e;i++){
            int u=s.nextInt();
            int v=s.nextInt();
            graph(arr,u-1,v-1);
        }
        printgraph(arr,n);
        s.close();
    }
}