import java.text.DecimalFormat;
import java.util.*;

public class ConnectingPoints_1 {

    private static class DisjointSets {
        int[] parents; 
        int[] ranks;  

        public DisjointSets (int n) {
            parents = new int[n];
            ranks = new int[n];
        }

        public void makeSet(int i) {
            parents[i] = i;
            ranks[i] = 1;            
        }

        public int find(int i) {
            if (parents[i] == i)    return i;
            
            return find(parents[i]);
        }

        public void union(int i, int j) {
            int r1 = find(i), r2 = find(j);
            
            if (r1 == r2) return;

            if (ranks[r1] < ranks[r2]) {
                parents[r1] = r2;
            }
            else if (ranks[r2] < ranks[r1]) {
                parents[r2] = r1;
            }
            else {
                parents[r2] = r1;
                ranks[r1] += 1;
            }
        }
    }

    private static class Edge {
        int u, v;
        double w;
        public Edge (int u, int v, double w) {
            this.u = u; this.v = v; this.w = w;
        }
        public String toString() {
            return u + "  " + v + "  " + w;
        }
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        int n = x.length;        
        DisjointSets sets = new DisjointSets(n);
        
        PriorityQueue<Edge> pq = new PriorityQueue(n, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.w < e2.w ? -1 : 1;
            }
        });
        
        for (int i = 0; i < n; i++) {
            sets.makeSet(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i ; j < n; j++) {                                
                if (i == j)  
                    continue;
                System.out.println("ln-103, i:"+i+", j:"+j+
                                   ", x["+i+"]:"+x[i]+", y["+i+"]:"+y[i]+
                                   ", x["+j+"]:"+x[j]+", y["+j+"]:"+y[j]+
                                   ", distance: "+distance(x[i], y[i], x[j], y[j]) );                            
                pq.offer(new Edge(i, j, distance(x[i], y[i], x[j], y[j])));
            }
        }
        
        while (! pq.isEmpty()) {
            Edge lightest = pq.poll();
            System.out.println("ln-104, " + lightest.toString());
            if (sets.find(lightest.u) != sets.find(lightest.v)) {
                sets.union(lightest.u, lightest.v);
                result += lightest.w;
            }
        }
        return result;
    }

 }
