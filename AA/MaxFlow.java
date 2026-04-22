import java.util.*;

class MaxFlow {
    static final int V = 6;

    // BFS to find augmenting path
    boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[t];
    }

    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;

        int rGraph[][] = new int[V][V];

        // Copy graph to residual graph
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V];
        int max_flow = 0;

        // Augment the flow while path exists
        while (bfs(rGraph, s, t, parent)) {

            int path_flow = Integer.MAX_VALUE;

            // Find minimum capacity
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // Update residual capacities
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };

        MaxFlow m = new MaxFlow();
        System.out.println("Maximum Flow: " + m.fordFulkerson(graph, 0, 5));
    }
}
