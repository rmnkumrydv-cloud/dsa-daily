class Solution {
    public int minCost(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;

        boolean[][] visi=new boolean[n][m];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        q.add(new int[]{0,0,0});
        int[] dx={0,0,1,-1};
        int [] dy={1,-1,0,0};
        
        while(!q.isEmpty()){
            int [] x=q.poll();
            
              if (visi[x[0]][x[1]]) continue;
              visi[x[0]][x[1]]=true;
              if(x[0]==n-1&&x[1]==m-1) return x[2];
            for(int i=0;i<4;i++){
                int row=dx[i]+x[0];
                int col=dy[i]+x[1];
                if(row>=0&&col>=0&&row<n&&col<m&&!visi[row][col]){
                    
                    if(i==grid[x[0]][x[1]]-1){
                        q.add(new int[]{row,col,x[2]});
                    }
                    else{
                        q.add(new int[]{row,col,x[2]+1});
                    }
                    

                }
            }

        }
        return 0;
    }
}