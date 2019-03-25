import java.util.*;

public class NegativeCycle_COMP550 {
    
  public static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        int n = adj.length;
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) { 
	    dist[i] = Integer.MAX_VALUE;	    
	}
	dist[0] = 0;

	for (int i = 1; i < n; i++) {  
        for (int u = 0; u < n; u++) 
           relax(u, adj[u], cost[u], dist);
    }
      
    System.out.println();	
    for (int i = 0; i < n; i++) {
        System.out.println("From 0 to " + i + ": " + dist[i]);
    }
    System.out.println();
       
    for (int u = 0; u < n; u++) {
        if (relax(u, adj[u], cost[u], dist))
		     return 1;
        }
        return 0;
    }

    private static boolean relax(int u, ArrayList<Integer> adjU, ArrayList<Integer> costU, int[] dist) {
        boolean distChanged = false;
        
        for (int i = 0; i < adjU.size(); i++) {
            int v = adjU.get(i); // v is neighbor of u
            if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + costU.get(i)) {
                dist[v] = dist[u] + costU.get(i);
		         System.out.println("ln-74, dist[" + v + "]: " + dist[v]);
                distChanged = true;
            }
        }
        return distChanged;
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
