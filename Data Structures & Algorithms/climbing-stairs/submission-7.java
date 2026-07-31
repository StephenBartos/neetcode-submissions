class Solution {
    public int climbStairs(int n) {
        int x = 1; // f(n-2)
        int y = 1; // f(n-1)
        for (int i = 0; i < n - 1; i++) {
            y = x + y;
            x = y - x;
        }
        return y;
    }
}
