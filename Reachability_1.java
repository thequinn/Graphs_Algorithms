import java.util.*;

public class Reachability_1 {
  
  private static int reach(ArrayList<Integer>[] adjLists, int x, int y) {
	  boolean[] visited = new boolean[adjLists.length];
	  return explore(adjLists, x, y, visited);
  }
	
  private static int explore(ArrayList<Integer>[] adjLists, int x, int y, boolean[] visited) {
    if (x == y)   return 1;
      
    visited[x] = true;
    for (int neighbor: adjLists[x]) {
      
      if (! visited[neighbor]) {
        explore(adjLists, neighbor, y, visited);
      }
    }
    return 0;
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

