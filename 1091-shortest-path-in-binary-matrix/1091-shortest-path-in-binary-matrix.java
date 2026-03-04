class Solution {
    class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int count=0;
        Queue<pair> q=new LinkedList<>();
        int len=grid.length;
        if(grid[0][0]!=0 ||grid[len-1][len-1]!=0) return -1;
        q.add(new pair(0,0));
        grid[0][0]=1;

        if (len == 1)
            return 1;
         int[][] dir = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };
        while(!q.isEmpty()){
            count++;
            int n=q.size();
            for(int i=0;i<n;i++){
            pair p=q.poll();
            for( int [] d: dir){
                int nr=p.x+d[0];
                int nc=p.y+d[1];
                if(nr==len-1&&nc==len-1) return count+1;
                if(nr>=0&&nr<len&&nc>=0&&nc<len){
                    if(grid[nr][nc]==0){
                        q.add(new pair(nr,nc));
                        grid[nr][nc]=1;
                    }
                }
            }
        } 
        }
        return -1;
    }
}