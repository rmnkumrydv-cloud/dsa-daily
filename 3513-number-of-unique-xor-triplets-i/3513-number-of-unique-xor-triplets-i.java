class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n==1||n==2) return n;
        int msb=31-Integer.numberOfLeadingZeros(n);
        return (int)Math.pow(2,msb+1);

    }
}