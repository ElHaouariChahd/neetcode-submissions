class Post {
    int tweetId;
    int date;

    public Post(int tweetId, int date) {
        this.tweetId = tweetId;
        this.date = date;
    }
}
class Twitter {
    PriorityQueue<Post> queue;
    HashMap<Integer, List<Post>> tweets;
    HashMap<Integer, Set<Integer>> following;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Post post = new Post(tweetId, time++);
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(post);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.date, a.date));

        List<Post> ownTweets = tweets.getOrDefault(userId, new ArrayList<>());
        queue.addAll(ownTweets);

        Set<Integer> users = following.getOrDefault(userId, new HashSet<>());

        for (int followeeId : users) {
            List<Post> posts = tweets.getOrDefault(followeeId, new ArrayList<>());
            queue.addAll(posts);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            result.add(queue.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;

        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
