class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int x: nums){
            low=Math.max(x,low);
            high+=x;
        }
        while(low<high){
            int mid =low+(high-low)/2;
            boolean ch= check(mid,k,nums);
            if(ch){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }
    private boolean check(int maxsum,int k,int [] nums){
        int count=1;
        int sum=0;
        for(int x: nums){
            if(x+sum>maxsum){
                count++;
                sum=x;
            }
            else{
                sum+=x;
            }
            if(count>k) return false;
        }
        return true;
    }
}