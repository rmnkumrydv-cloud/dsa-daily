class Solution {
    public int maxProduct(int n) {
        int temp=n;
        int first=0;
        int second=0;
        while(temp>0){
            int rem=temp%10;
            if(first<rem){
                second=first;
                first=rem;
            }
            else if (second<rem){
                second=rem;
            }
            temp/=10;
        }
        return first*second;
    }
}