class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(s, 0,dp);
    }

    private int decode(String s, int i,int [] dp) {
        if (i == s.length())
            return 1;

        if (s.charAt(i) == '0')
            return 0;
        if(dp[i]!=-1) return dp[i];
        int count = decode(s, i + 1,dp);

        if (i < s.length() - 1) {
            int num = (s.charAt(i) - '0') * 10 +
                    (s.charAt(i + 1) - '0');

            if (num >= 10 && num <= 26) {
                count += decode(s, i + 2,dp);
            }
        }
        dp[i]=count;
        return count;
    }
}