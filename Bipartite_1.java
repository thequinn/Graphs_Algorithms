import java.util.*;

public class Bipartite_1 {
    
  private static int bipartite(ArrayList<Integer>[] adj) {
        int[] dist = new int[adj.length];
        boolean[] color = new boolean[adj.length];
        
        for (int i = 0; i < adj.length; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);  // Add 0 to the end of the list
        
        while (! queue.isEmpty()) {
            int u = queue.poll();  // Retrieve and remove the front of the list
            for (int v : adj[u]) { // Loop thr all neighbors of u
                if (dist[v] == Integer.MAX_VALUE) {
                    queue.offer(v);  // Add v to the end of the list
                    dist[v] = dist[u] + 1;
                    color[v] = ! color[u];
                }
                // v is visited and same color as u, no bipartite.
                else if (color[v] == color[u])
                    return 0;
            }
        }
        return 1;
    }

}
