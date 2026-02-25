class Solution {
    public int maxProfit(int[] prices, int fee) {
        int [][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        

        return get(0,1,prices,fee,dp);
    }
    private int get(int curr,int flag,int[] prices,int fee,int [][] dp){
        if(curr>=prices.length) return 0;
        int profit=0;
        if(dp[curr][flag]!=-1) return dp[curr][flag];
        if(flag==1){
            int take=-prices[curr]+get(curr+1,0,prices,fee,dp);
            int ntake=get(curr+1,1,prices,fee,dp);
            profit=Math.max(take,ntake);
        }
        else{
            int sell=prices[curr]+get(curr+1,1,prices,fee,dp)-fee;
            int nsell=get(curr+1,0,prices,fee,dp);
            profit=Math.max(sell,nsell);
        }
        dp[curr][flag]=profit;
        return profit;
    }
}