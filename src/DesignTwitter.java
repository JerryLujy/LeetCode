import java.util.*;

/**
 * <h1>355. Design Twitter</h1>
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see
 * the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * <p>
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * <p>
 * follow(followerId, followeeId): Follower follows a followee.
 * <p>
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 * @author Jerry
 * @since 2/28/17
 */
public class DesignTwitter {
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, TweetNode> tweets;
    private int time;

    /**
     * Initialize your data structure here.
     */
    public DesignTwitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        TweetNode tweet = new TweetNode(time++, tweetId);
        if (tweets.containsKey(userId)) {
            tweet.next = tweets.get(userId);
        }
        tweets.put(userId, tweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Queue<TweetNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> -l.time));
        if (tweets.containsKey(userId)) {
            queue.add(tweets.get(userId));
        }
        if (follows.containsKey(userId)) {
            for (int followee : follows.get(userId)) {
                if (tweets.containsKey(followee)) {
                    queue.add(tweets.get(followee));
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (queue.isEmpty()) {
                break;
            }
            TweetNode tweet = queue.poll();
            ans.add(tweet.id);
            if (tweet.next != null) {
                queue.offer(tweet.next);
            }
        }
        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            return;
        }
        follows.get(followerId).remove(followeeId);
    }

    private class TweetNode {
        int time;
        int id;
        TweetNode next;

        TweetNode(int t, int i) {
            time = t;
            id = i;
        }
    }
}
