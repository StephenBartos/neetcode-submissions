class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [a, b, c, d] = [b*c*d, a*c*d, a*b*d, a*b*c]
        int[] result = new int[nums.length];

        int left = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}  
