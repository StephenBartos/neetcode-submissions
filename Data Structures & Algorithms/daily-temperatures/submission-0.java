class Solution {
    // [3, 2, 1, 4] => [3, 2, 1, 0]
    // stack = [3] -> [3, 2] -> [3, 2, 1] -> 

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int topIndex = stack.pop();
                result[topIndex] = i - topIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
