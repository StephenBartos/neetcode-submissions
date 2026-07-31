class Solution {
    public int rob(int[] nums) {
        // dp[i] = Most money you can rob from the ith house and onwards
        int next1 = 0; // dp[i+1]
        int next2 = 0; // dp[i+2]
        for (int i = nums.length - 1; i >= 0; --i) {
            int curr = Math.max(next1, nums[i] + next2); // Either skip house i+1 or rob it
            next2 = next1;
            next1 = curr;
        }
        return Math.max(next1, next2);
    }
}
