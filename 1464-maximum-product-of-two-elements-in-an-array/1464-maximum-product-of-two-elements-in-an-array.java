class Solution {
    public int maxProduct(int[] nums) {
        int f=nums[0];
        int s=-1;
        for(int i=1;i<nums.length;i++){
            if(f<=nums[i]){
                s=f;
                f=nums[i];
            } 
            else if(s<nums[i]){
                s=nums[i];
            }  
        }
        return (f-1)*(s-1);
    }
}