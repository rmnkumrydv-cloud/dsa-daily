class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp=new int [word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        } 
        return check(word1,word2,0,0,dp);
        
    }
    private  int check(String a ,String b,int i,int j,int [][] dp){
        if(i==a.length()) return b.length()-j;
        if(j==b.length()) return a.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
          dp[i][j]=  check(a,b,i+1,j+1,dp);
          return dp[i][j];
        }
    
        else{
            int  x=1+check(a,b,i+1,j,dp);
             int y=1+check(a,b,i,j+1,dp);
             int z=1+check(a,b,i+1,j+1,dp);
            dp[i][j]= Math.min(x,Math.min(y,z));
            return dp[i][j];
        }
    }
}