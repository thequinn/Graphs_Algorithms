

import java.util.*;

public class Dijkstra_1 {
    
    public static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int n = adj.length;
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        
        dist[s] = 0;
        
        for (int j = 0; j < n; j++) {
            int u = minDistVertex(dist, visited);
        
            if (u == -1) continue;
            
            visited[u] = true;
            
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i), w = cost[u].get(i);
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                }
            }
        }
        
        return dist[t] == Integer.MAX_VALUE ? -1 : dist[t];
    }

    public static int minDistVertex(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE, minVertex = -1;
        
        for (int v = 0; v < dist.length; v++) {
            if (visited[v]) continue;
            if (dist[v] < minDist) minVertex = v;
            minDist = Math.min(minDist, dist[v]);
        }
        
        return minVertex;
    }
    
}
