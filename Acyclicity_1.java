import java.util.*;

public class Acyclicity_1 {

    public static int acyclic(ArrayList<Integer>[] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        boolean[] onstack = new boolean[n];
        for (int v = 0; v < n; v++) {
          if (! visited[v]) {
            if (dfs(v, adj, visited, onstack) == 1)
              return 1;
          }
        }
        return 0;
    }

    private static int dfs(int vertex, ArrayList<Integer>[] adj,
            boolean[] visited, boolean[] onstack) {
      visited[vertex] = true;
      onstack[vertex] = true;
      for (int w : adj[vertex]) {
        if (! visited[w]) {
          if (dfs(w, adj, visited, onstack) == 1)
            return 1;
        }
        if (visited[w] && onstack[w])
          return 1;
      }
      
           onstack[vertex] = false;  
      
            return 0;
    }

}
