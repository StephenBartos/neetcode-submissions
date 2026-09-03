class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = LinkedHashSet.newLinkedHashSet(nums.length);
        for (int n : nums) {
            numSet.add(n);
        }

        int result = 0;
        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                // n is the start of a sequence
                int curr = n + 1;
                while (numSet.contains(curr)) {
                    // n+1, n+2, ... is in the set
                    curr++;
                }
                result = Math.max(curr - n, result);
            }
        }
        return result;
    }
}
