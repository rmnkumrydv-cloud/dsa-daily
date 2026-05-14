class Solution {
    public long minimalKSum(int[] nums, int k) {
        int n=nums.length;
    Arrays.sort(nums);
    int left=0;
    long count=1;
    int kp=0;
    long sum=0;
    while(left<n){
        if(kp==k) return sum;
            
          if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
        if(nums[left]!=count){
            kp++;
            sum+=count;
            count++;
            
        }
        else{
             count++; 
            left++;
          
        }
    }
    while(kp!=k){
        
        sum+=count;
        count++;
        kp++;
    }
    return sum;
    }
}