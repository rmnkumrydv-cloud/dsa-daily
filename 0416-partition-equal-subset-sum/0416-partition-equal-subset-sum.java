class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
      
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        Boolean [][] dp =new Boolean[nums.length][sum/2+1];
        return solve(0,sum/2,nums,dp);

    }
    private boolean solve(int index,int sum,int [] nums,Boolean [][] dp){
        if(sum==0) return true;
        if(index>=nums.length) return false;
        if(dp[index][sum]!=null) return dp[index][sum];
        boolean nt=solve(index+1,sum,nums,dp);
        boolean take=false;
        if(nums[index]<=sum){
            take=solve(index+1,sum-nums[index],nums,dp);
        }
        dp[index][sum]=take||nt;
        return  take||nt;
    }
}