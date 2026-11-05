class Twitter {

    class Tweet {

        int count;
        int tweetId;

        public Tweet(int count, int tweetId) {
            this.count = count;
            this.tweetId = tweetId;
        }

        public int getCount() { return this.count; }
        public int getTweetId() { return this.tweetId; }
    }

    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    PriorityQueue<Tweet> maxHeap;
    int count;

    public Twitter() {

        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> 
                                        Integer.compare(b.getCount(), a.getCount()));
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {

        count++;

        if (!tweetMap.containsKey(userId)) {

            tweetMap.put(userId, new ArrayList<>());
        }

        Tweet tweet = new Tweet(count, tweetId);
        tweetMap.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        // Before fetching newFeed, I'll add that user in it's own followee list,
        // It'll help in picking it's own tweets too (requirement)
        follow(userId, userId);       

        // Putting all tweets from user followee's, including itself, into maxHeap
        if (followMap.containsKey(userId)) {

            for (int followeeId : followMap.get(userId)) {

                if (tweetMap.containsKey(followeeId)) {

                    for (Tweet tweet : tweetMap.get(followeeId)) {

                        maxHeap.add(tweet);
                    }
                }
            }
        }

        // Fetching top 10 tweets for userId from maxHeap

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {

            result.add(maxHeap.poll().getTweetId());
        }

        // Cleaning heap so that remaining data doesn't affect next method call.
        maxHeap.clear();
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {

        if (!followMap.containsKey(followerId)) {

            followMap.put(followerId, new HashSet<>());
        }

        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {

            followMap.get(followerId).remove(followeeId);
            if (followMap.get(followerId).size() == 0) {

                followMap.remove(followerId);
            }
        }
    }
}
