class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0, target);
        return result;
    }

    public void backtrack(
            List<List<Integer>> result,
            List<Integer> currList,
            int[] nums,
            int start,
            int remaining) {
        if (remaining == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remaining) {
                continue;
            }
            currList.add(nums[i]);
            backtrack(result, currList, nums, i, remaining - nums[i]);
            currList.remove(currList.size() - 1);
        }
    }
}
