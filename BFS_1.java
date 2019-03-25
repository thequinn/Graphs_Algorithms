import java.util.*;

public class BFS_1 {

    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        int[] dist = new int[adj.length];
        for (int i = 0; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);  // Add s to the end of the lis
        
        while (! queue.isEmpty()) {
            int u = queue.poll();  // Retrieve and remove the front of the list
            for (int v : adj[u]) {
                if (dist[v] == Integer.MAX_VALUE) {
                    queue.offer(v);  // Add v to the end of the lis
                    dist[v] = dist[u] + 1;
                }
            }
        }
        return dist[t] == Integer.MAX_VALUE ? -1 : dist[t];
    }
}
