class Solution {
    public long gcdSum(int[] nums) {
        long sum=0;
        int n=nums.length;
        int[] res= new int[n];
         int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            res[i]=gcd(max,nums[i]);
        }
        Arrays.sort(res);
        int left=0;
        int right=n-1;
        while(left<right){
            sum+=gcd(res[left],res[right]);
            left++;
            right--;
        }
        return sum;
    }
    private int gcd(int a ,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}