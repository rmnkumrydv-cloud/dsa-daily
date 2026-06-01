class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        if(flowerbed.length==1){
            if(flowerbed[0]==0){
                n--;
            }
            return n==0;
        } 
         if(flowerbed[0]==0&&flowerbed[1]==0){
            n--;
            flowerbed[0]=1;
        }
        if(n==0) return true;
        for(int i=1;i<flowerbed.length-1;i++){
           if(n==0) return true;
           if(flowerbed[i-1]==0&&flowerbed[i+1]==0&&flowerbed[i]==0){
            flowerbed[i]=1;
            n--;
           }
        }
       
        int t=flowerbed.length;
        if(flowerbed[t-1]==0&&flowerbed[t-2]==0){
            n--;
        }
        return n==0;
    }
}