import java.util.*;
class Graph {
    int vertices;
    static ArrayList<ArrayList<Integer>> adj;
    Graph(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>();
        for (int i = 0; i < vertices + 1; i++) {
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u, int v) {
        adj.get(u).add(v);
//        adj.get(v).add(u);
    }
    void printGraph() {
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j));
                if (j < adj.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    static void bfs(int start) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int neighbor : adj.get(start)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
}
public class AdjacencyListGraph {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Graph g = new Graph(n);
        System.out.println("Enter the Edges:");
        int e = s.nextInt();
        for (int i = 0; i < e; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            g.addEdge(u, v);
        }
        g.printGraph();
        int start = s.nextInt();
        System.out.println("BFS:");
        g.bfs(start);
        System.out.println();
        boolean[] visited = new boolean[n + 1];
        int starts = s.nextInt();
        System.out.println("DFS:");
        g.dfs(starts, visited);
        s.close();
    }
}