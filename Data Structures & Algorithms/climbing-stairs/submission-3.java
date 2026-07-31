class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int x = 1; // f(n-2)
        int y = 1; // f(n-1)
        int z;     // f(n)
        for (int i = 2; i <= n; i++) {
            z = x + y;
            x = y;
            y = z;
        }
        return y;
    }
}
