class Solution {
    class pair{
        int time,dest;
        pair(int t,int d){
            this.time=t;
            this.dest=d;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int time=0;
        ArrayList<ArrayList<int[]>> arr=new ArrayList<>();
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }
        for(int []  r: times ){
            int u=r[0];
            int v=r[1];
            int w =r[2];
            arr.get(u).add(new int[]{v,w});

        }
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)-> a.time-b.time);
        q.add(new pair(0,k));
        int []dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!q.isEmpty()){
            pair p=q.poll();
            for(int [] r: arr.get(p.dest)){
                if(dist[r[0]]>p.time+r[1]){
                    q.add(new pair(p.time+r[1],r[0]));
                    dist[r[0]]=p.time+r[1];
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}