class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int num:weights){
            low=Math.max(num,low);
            high+=num;
        }
        while(low<high){
            int mid =low+(high-low)/2;
            boolean ch=check(mid,weights,days);
            if(ch){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;

    }
    private  boolean check(int x,int [] weights,int days){
        int curr=0;
        int day=1;
        for(int i=0;i<weights.length;i++){
            if(curr+weights[i]>x){
                day++;
                curr=0;
            }
            curr+=weights[i];
        }
        return days>=day;
    }
}