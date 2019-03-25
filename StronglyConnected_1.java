import java.util.*;

public class StronglyConnected_COMP550 {
   
  private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        ArrayList<Integer>[] adjR = reverseGraph(adj);
        Stack<Integer> post = new Stack();
        boolean[] visited = new boolean[adj.length];

        for (int v = 0; v < adj.length; v++) {
            if (! visited[v])
                dfs(adjR, v, visited, post);
        }
        
        int res = 0; 
        visited = new boolean[adj.length];
        
        while (! post.isEmpty()) {
            int v = post.pop();
            
            if (visited[v])     continue;
            
            dfs(adj, v, visited, null);
            res++;
        }
        return res;
    }

    private static ArrayList<Integer>[] reverseGraph(ArrayList<Integer>[] adj) {
        ArrayList<Integer>[] res = new ArrayList[adj.length];
        
        for (int v = 0; v < adj.length; v++)
            res[v] = new ArrayList();
        
        for (int v = 0; v < adj.length; v++) {
            for (int w : adj[v]) {
                res[w].add(v);
                System.out.println("res[" + w + "]: " + res[w]);
            }
        }
        return res;
    }

    private static void dfs(ArrayList<Integer>[] adj, int v,
            boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int w : adj[v]) {
            if (! visited[w]) {
                dfs(adj, w, visited, stack);
            }
        }
        // Postorder(): push all post vertex.
        if (stack != null)
            stack.push(v);
    }

 }
