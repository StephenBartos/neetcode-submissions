class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}
