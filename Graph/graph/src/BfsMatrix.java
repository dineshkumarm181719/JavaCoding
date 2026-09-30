import java.util.*;
public class BfsMatrix {
    static void graph(int[][] arr, int u, int v) {
        arr[u][v] = 1;
        arr[v][u] = 1;
    }
    static void bfs(int[][] arr, int n, int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print((current + 1) + " ");
            for (int i = 0; i < n; i++) {
                if (arr[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    static void dfs(int[][] arr, int n, int starts, boolean[] visited) {
        visited[starts] = true;
        System.out.print((starts + 1) + " ");
        for (int i = 0; i < n; i++) {
            if (arr[starts][i] == 1 && !visited[i]) {
                dfs(arr, n, i, visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Enter the Edges");
        int e = s.nextInt();
        for (int i = 0; i < e; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            graph(arr, u - 1, v - 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int start = s.nextInt();
        System.out.print("BFS: ");
        bfs(arr, n, start - 1);
        System.out.println();
        int dfsStart = s.nextInt();
        boolean[] visited = new boolean[n];
        System.out.print("DFS: ");
        dfs(arr, n, dfsStart - 1, visited);
        s.close();
    }
}