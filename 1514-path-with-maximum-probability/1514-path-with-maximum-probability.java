class Solution {
    class pair {
        int u;
        double prob;
        pair(int u,double p){
            this.u=u;
            this.prob=p;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<pair>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] x = edges[i];
            int u = x[0];
            int v = x[1];
            arr.get(u).add(new pair(v,succProb[i]));
            arr.get(v).add(new pair(u,succProb[i]));
            
        }
        PriorityQueue<pair> q = new PriorityQueue<>(
    (a, b) -> Double.compare(b.prob, a.prob)
);
        boolean[] visi = new boolean[n];
        q.add(new pair(start_node,1.0));
        visi[start_node] = true;
        while (!q.isEmpty()) {
            pair x = q.poll();
            if (x.u == end_node) {
                return x.prob;
            }
           
            visi[x.u] = true;
            for (pair  p : arr.get(x.u)) {
                if (!visi[p.u]) {
                    q.add(new pair(p.u,x.prob*p.prob));
                }
            }
        }
        return 0;
    }
}