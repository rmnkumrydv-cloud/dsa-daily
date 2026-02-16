class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int c: nums){
            high=Math.max(high,c);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            boolean ch= check(mid,threshold,nums);
            if(ch){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;

    }
    private boolean check(int div,int max,int [] nums){
        int sum=0;
        for( int c: nums){
            if(c%div==0){
                sum+=c/div;
            }
            else{
                sum+=c/div + 1;
            }
            if(sum>max) return false;
        }
        return true;
    }
}