class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new LinkedHashMap<>();
        int maxCount = 0;
        for (int n : nums) {
            if (!numToCount.containsKey(n)) {
                numToCount.put(n, 1);
            }
            int newCount = numToCount.get(n) + 1;
            numToCount.put(n, newCount);
            if (newCount > maxCount) {
                maxCount = newCount;
            }
        }

        List<List<Integer>> buckets = new ArrayList<>(maxCount + 1);
        for (int i = 0; i <= maxCount + 1; i++ ) {
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (buckets.get(count) == null) {
                buckets.set(count, new ArrayList<>());
            }
            buckets.get(count).add(num);
        }

        int[] result = new int[k];
        int resultIndex = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Integer> bucket = buckets.get(i);
            for (int n : bucket) {
                if (resultIndex == k) {
                    return result;
                }
                result[resultIndex] = n;
                resultIndex++;
            }
        }

        return result;
    }
}
