class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n-1), robRange(nums, 1, n)); // [0, n-1] and [1, n]
    }

    public int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = start; i < end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
