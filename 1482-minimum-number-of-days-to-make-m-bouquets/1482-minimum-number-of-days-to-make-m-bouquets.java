class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) return -1;

        int low=1;
        int high=0;
        for (int d:bloomDay) high=Math.max(high,d);
        while(low<high){
            int mid =low+(high-low)/2;
            boolean ch=check(mid,m,k,bloomDay);
            if(ch){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }
    private boolean check(int mid,int b,int f ,int [] arr){
        int count =0;
        int book=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
                if(count==f){
                    book++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return b<=book;
    }
}