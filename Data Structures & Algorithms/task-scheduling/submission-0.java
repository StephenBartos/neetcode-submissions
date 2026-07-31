class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequency of each task
        int[] taskToFrequency = new int[26]; // Uppercase letters
        for (char c : tasks) {
            taskToFrequency[c - 'A']++;
        }
        // Insert each task into a maxHeap based on its frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> 
            Integer.compare(taskToFrequency[b], taskToFrequency[a])
        );
        for (int i = 0; i < taskToFrequency.length; i++) {
            if (taskToFrequency[i] > 0) {
                maxHeap.offer(i);
            }
        }
        // Initialize a waitlist to hold tasks that need to run again
        // The waitlist stores both the task and the timestamp of when it should be removed
        Queue<int[]> waitlist = new ArrayDeque<>(); // int[]{task, timestamp}
        // Initialize a timer to simulate the CPU and begin the simulation
        int timer = 0;
        while (!maxHeap.isEmpty() || !waitlist.isEmpty()) {
            timer++;
            if (!maxHeap.isEmpty()) {
                int taskIndex = maxHeap.poll();
                int frequency = --taskToFrequency[taskIndex];
                if (frequency > 0) {
                    waitlist.offer(new int[]{taskIndex, n + timer});
                }
            }
            if (!waitlist.isEmpty() && waitlist.peek()[1] == timer) {
                int task = waitlist.poll()[0];
                maxHeap.offer(task);
            }
        }
        return timer;
    }
}
