import java.util.*;

public class ConnectedComponents_1 {

  private static int numberOfComponents(ArrayList<Integer>[] adj) {
    boolean[] visited = new boolean[adj.length];
    int cc = 1; 
    for (int i = 0; i < adj.length; i++) {
      if (! visited[i]) {
        explore(adj, i, visited); 
        ++cc;                     
      }
    }
    return --cc;
  }
	
  private static void explore(ArrayList<Integer>[] adj, int x, boolean[] visited) {
    visited[x] = true;
    
    for (int neighbor: adj[x]) {
      if (! visited[neighbor]) {
        explore(adj, neighbor, visited);
      }
    }
  }
}

