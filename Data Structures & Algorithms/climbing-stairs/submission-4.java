class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int x = 1; // f(n-2)
        int y = 1; // f(n-1)
        for (int i = 2; i <= n; i++) {
            y = x + y;
            x = y - x;
        }
        return y;
    }
}
