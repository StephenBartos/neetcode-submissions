class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p + mid - 1) / mid; // ceiling of rate
            }
            if (time <= h) {
                // Eating rate was fast enough, try a slower one
                result = mid;
                right = mid - 1;
            } else {
                // Eating rate was too slow, try a faster one
                left = mid + 1;
            }
        }
        return result;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }

}
