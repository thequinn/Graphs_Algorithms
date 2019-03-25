
import java.util.*;

public class Kruskal_1{
    
    static class DisjointSets {
        private int[] parents;  // Trace Disjoint Sets
        
        private int[] ranks;    

        public DisjointSets (int n) {
            parents = new int[n];
            ranks = new int[n];
        }

        void makeSet(int i) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int find(int i) {
            if (parents[i] == i)    return i;
            
            return find(parents[i]);
        }

        void weighted_union_MyTutorials(int i, int j) {
            int r1 = find(i), r2  = find(j);
            if (ranks[r1] < ranks[r2]) {
                parents[r1] = r2;
                ranks[r2] += ranks[r1];
            }
            else {
                parents[r2] = r1;
                ranks[r1] += ranks[r2];
            }
        }
        
        void weighted_union_COMP550(int i, int j) {
            int r1 = find(i), r2  = find(j);
            System.out.print("\ni:"+i+", j:"+j+", r1:"+r1+", r2: "+r2);
            System.out.println(", ranks[r1]: "+ranks[r1]+", ranks[r2]: "+ranks[r2]);

            if (ranks[r1] < ranks[r2]) {
				      parents[r1] = r2;  // Link r1 under r2
			} else {
				
        parents[r2] = r1;
				
        if (ranks[r1] == ranks[r2]) {
					ranks[r1]++;
				}
			}
        }
    
        void printDisjointSets(int n) {
            System.out.print("parents[]: ");
            for (int i = 0; i < n; i++) {
                System.out.print(parents[i] + " ");
            }
            System.out.print(", ranks[]: ");
            for (int i = 0; i < n; i++) {
                System.out.print(ranks[i] + " ");
            }
            System.out.print("\n");
        }
    }

    static class Edge {
        int u;
        int v;
        int w;
        public Edge (int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int minSpanningTree(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        int n = adj.length;
        DisjointSets sets = new DisjointSets(n);
        for (int i = 0; i < n; i++) {
            sets.makeSet(i);
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue(n, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.w - e2.w;
            }
        });
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj[i].size(); j++) {                
                pq.offer(new Edge(i, adj[i].get(j), cost[i].get(j)));
            }
        }
        
        int result = 0;
        while (! pq.isEmpty()) {
            Edge lightestEdge = pq.poll();
            
            if (sets.find(lightestEdge.u) != sets.find(lightestEdge.v)) {
                sets.weighted_union_COMP550(lightestEdge.u, lightestEdge.v);
                sets.printDisjointSets(n);
                result += lightestEdge.w;  
            }
        }

        return result;
    }
    
}

