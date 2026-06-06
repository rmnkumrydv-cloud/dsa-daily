class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
       int[] post =new int[n];
       post[n-1]=0;
       for(int i=n-2;i>=0;i--){
        post[i]=nums[i+1]+post[i+1];
       }
       int[] pre=new int[n];
       pre[0]=0;
       int [] arr=new int[n];
       for(int i=0;i<n;i++){
        if(i!=0) pre[i]=nums[i-1]+pre[i-1];
        arr[i]=Math.abs(pre[i]-post[i]);
       }
       return arr;
    }
}