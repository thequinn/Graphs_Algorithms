import java.util.*;

public class Toposort_1 {
    
  private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
    int used[] = new int[adj.length];
    ArrayList<Integer> order = new ArrayList<Integer>();
    
    for (int v = 0; v < adj.length; v++) {
      if (used[v] == 0)
        dfs(adj, used, order, v);
    }

    Collections.reverse(order); 
    return order;
  }

  private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
    used[s] = 1;

    for (int t : adj[s]) {
      if (used[t] == 0)
        dfs(adj, used, order, t);
    }

    order.add(s);  // Add to the end of ArrayList 
  }

  public static void printAdj(int n, ArrayList<Integer>[] adjLists){
    System.out.println("\nAdjacency List created:");
    for (int i = 0; i < n; i++) {
      System.out.print(i + ": ");
      for (int j = 0; j < adjLists[i].size(); j++) { 
        System.out.print(adjLists[i].get(j) + " "); 
      } 
      System.out.println(); 
    }
  }
  
}
