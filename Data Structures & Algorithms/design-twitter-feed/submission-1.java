class Twitter {
    public int timestamp = 0; // simpler than storing actual datetimes
    // userId -> set(followeeIds)
    public Map<Integer, Set<Integer>> follows; // Who a user follows
    // userId -> list(tweetId, timestamp)
    public Map<Integer, List<int[]>> userToTweets; // Each tweet stores the tweetId and its timestamp AKA "timestamp"

    public Twitter() {
        this.follows = new HashMap<>();
        this.userToTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userToTweets.containsKey(userId)) {
            userToTweets.put(userId, new ArrayList<>());
        }
        userToTweets.get(userId).add(new int[]{tweetId, this.timestamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        // int[]{tweetId, timestamp, userId, index} (index in users's tweet list)
        // We use the index to add the next tweet after the prior one is removed from the heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); // greater timestamp => more recent

        // Add the user's most recent tweet 
        if (userToTweets.containsKey(userId)) {
            List<int[]> tweets = userToTweets.get(userId);
            if (tweets != null && !tweets.isEmpty()) {
                int lastIndex = tweets.size() - 1;
                int[] lastTweet = tweets.get(lastIndex);
                int tweetId = lastTweet[0], timestamp = lastTweet[1];
                heap.offer(new int[]{tweetId, timestamp, userId, lastIndex});
            }
        }
        // Add the most recent tweet for each followee
        if (follows.containsKey(userId)) {
            Set<Integer> followeeIdSet = follows.get(userId);
            if (followeeIdSet != null && !followeeIdSet.isEmpty())
            for (int followeeId : followeeIdSet) {
                if (userId == followeeId) {
                    continue;
                }
                if (userToTweets.containsKey(followeeId)) {
                    List<int[]> tweets = userToTweets.get(followeeId);
                    if (tweets != null && !tweets.isEmpty()) {
                        int lastIndex = tweets.size() - 1;
                        int[] lastTweet = tweets.get(lastIndex);
                        int tweetId = lastTweet[0], timestamp = lastTweet[1];
                        heap.offer(new int[]{tweetId, timestamp, followeeId, lastIndex});
                    }
                }
            }
        }
        while (!heap.isEmpty() && newsFeed.size() < 10) {
            // Poll and unpack the top entry in the heap
            int[] topTweet = heap.poll();
            int tweetId = topTweet[0];
            int timestamp = topTweet[1];
            int uId = topTweet[2];
            int index = topTweet[3];
            // This tweet is the most recent one, add it to the result
            newsFeed.add(tweetId);
            // Add the next most recent tweet that is associated with this user to the heap
            int nextIndex = index - 1;
            if (nextIndex >= 0) {
                int[] nextTweet = userToTweets.get(uId).get(nextIndex);
                heap.offer(new int[]{nextTweet[0], nextTweet[1], uId, nextIndex});
            }
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            follows.put(followerId, new HashSet<>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follows.get(followerId).remove(followeeId);
    }
}
