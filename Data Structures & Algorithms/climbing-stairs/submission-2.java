class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        return dfs(n, 0, memo);
    }

    public int dfs(int n, int i, int[] memo) {
        if (i == n) {
            return 1;
        }
        if (i > n) {
            return 0;
        }

        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = dfs(n, i + 1, memo) + dfs (n, i + 2, memo);
        return memo[i];
    }
}
