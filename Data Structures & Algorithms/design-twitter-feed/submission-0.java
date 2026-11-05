class Twitter {

    Map<Integer, List<List<Integer>>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    PriorityQueue<List<Integer>> maxHeap;
    int count;

    public Twitter() {

        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> 
                                        Integer.compare(b.get(0), a.get(0)));
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {

        count++;

        if (!tweetMap.containsKey(userId)) {

            tweetMap.put(userId, new ArrayList<>());
        }

        List<Integer> tweet = new ArrayList<>();
        tweet.add(count);
        tweet.add(tweetId);
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

                    for (List<Integer> tweetList : tweetMap.get(followeeId)) {

                        maxHeap.add(tweetList);
                    }
                }
            }
        }

        // Fetching top 10 tweets for userId from maxHeap

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {

            result.add(maxHeap.poll().get(1));
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
