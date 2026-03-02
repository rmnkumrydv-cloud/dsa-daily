class Solution {
    public int maxProfit(int[] prices) {
        int [][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return get(0,prices,1,dp);
    }
    private int get(int curr,int [] prices,int  buy,int[][] dp){
        if(curr>=prices.length) return 0;
        int b=0,nb=0,s=0,ns=0;
        if(dp[curr][buy]!=-1) return dp[curr][buy];
        if(buy==1){
            
             b=-prices[curr]+get(curr+1,prices,0,dp);
             nb=get(curr+1,prices,1,dp);
             dp[curr][buy]= Math.max(b,nb);
             return dp[curr][buy];

        }
        else{
            s=prices[curr]+get(curr+2,prices,1,dp);
            ns=get(curr+1,prices,0,dp);
            dp[curr][buy]=Math.max(s,ns);
           return dp[curr][buy];
        }
        
    }
}