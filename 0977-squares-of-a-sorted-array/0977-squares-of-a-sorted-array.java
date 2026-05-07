class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int[] res=new int[nums.length];
        int count=nums.length-1;
        while(l<=r){
            if(nums[l]*nums[l]<nums[r]*nums[r]){
                res[count]=nums[r]*nums[r];
                count--;
                r--;
            }
            else{
                res[count]=nums[l]*nums[l];
                count--;
                l++;
            }
        }
        return res;
    }
}