class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = get(0, 0, amount, coins, dp);
        return ans >= amount + 1 ? -1 : ans;
    }

    private int get(int sum, int curr, int amount, int[] coins, int[][] dp) {

        if (sum == amount) return 0;

        if (curr >= coins.length) return 100000;

        if (dp[curr][sum] != -1) return dp[curr][sum];

        int take = 100000;

        if (sum <= amount - coins[curr]) {
            take = 1 + get(sum + coins[curr], curr, amount, coins, dp);
        }

        int notTake = get(sum, curr + 1, amount, coins, dp);

        return dp[curr][sum] = Math.min(take, notTake);
    }
}