class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=Integer.MIN_VALUE;
        for (int num: piles){
            max=Math.max(num,max);
        }
        while(min<max){
            int mid =min+(max-min)/2;
            boolean ch=check(mid,piles,h);
            if(ch){
                max=mid;
            }
            else{
                min=mid+1;
            }

        }
        return min;
    }
    private boolean check(int x ,int [] piles,int h){
        int count=0;
        for(int num:piles){
            count+=(num+x-1)/x;
            if(count>h)return false;
        }
        return true;
    }
}