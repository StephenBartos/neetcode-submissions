class Twitter {
    record Tweet(int id, int timestamp) {}
    record FeedEntry(int tweetId, int timestamp, int userId, int index) {}
    public int timestamp = 0; // simpler than storing actual datetimes
    // userId -> set(followeeIds)
    public Map<Integer, Set<Integer>> follows; // Who a user follows
    // userId -> list(tweetId, timestamp)
    public Map<Integer, List<Tweet>> userToTweets; // Each tweet stores the tweetId and its timestamp AKA "timestamp"

    public Twitter() {
        this.follows = new HashMap<>();
        this.userToTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userToTweets.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new Tweet(tweetId, this.timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        // We use the index to add the next tweet after the prior one is removed from the heap
        PriorityQueue<FeedEntry> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp)); // greater timestamp => more recent

        // Add the user's most recent tweet 
        addLatestTweet(heap, userId);
        // Add the most recent tweet for each followee
        Set<Integer> followeeIdSet = follows.getOrDefault(userId, Collections.emptySet());
        for (int followeeId : followeeIdSet) {
            if (userId == followeeId) {
                continue;
            }
            addLatestTweet(heap, followeeId);
        }
        while (!heap.isEmpty() && newsFeed.size() < 10) {
            // Poll and unpack the top entry in the heap
            FeedEntry topFeedEntry = heap.poll();
            // This tweet is the most recent one, add it to the result
            newsFeed.add(topFeedEntry.tweetId);
            // Add the next most recent tweet that is associated with this user to the heap
            int nextIndex = topFeedEntry.index - 1;
            if (nextIndex >= 0) {
                Tweet nextTweet = userToTweets.get(topFeedEntry.userId).get(nextIndex);
                heap.offer(new FeedEntry(nextTweet.id, nextTweet.timestamp, topFeedEntry.userId, nextIndex));
            }
        }
        return newsFeed;
    }

    public void addLatestTweet(PriorityQueue<FeedEntry> heap, int userId) {
        List<Tweet> tweets = userToTweets.getOrDefault(userId, Collections.emptyList());
        if (!tweets.isEmpty()) {
            int lastIndex = tweets.size() - 1;
            Tweet lastTweet = tweets.get(lastIndex);
            heap.offer(new FeedEntry(lastTweet.id, lastTweet.timestamp, userId, lastIndex));
        }
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = follows.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}
