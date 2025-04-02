package project00;

public class UserAccount {
    private String email;
    private String userName;

    private final int MAX_POST = 100;
    private final int MAX_TIMELINE = 10;
    private final int MAX_FOLLOWERS = 100;

    private Post[] userPosts;
    private int totalPosts;

    private UserAccount[] userFollowers;
    private int totalFollowers;

    private Post[] userTimeline;
    private int totalTimeline;

    public String getUserName() { return userName; }

    public UserAccount[] getFollowers() {
        return userFollowers;
    }

    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;
        this.userPosts = new Post[MAX_POST];
        this.userFollowers = new UserAccount[MAX_FOLLOWERS];
        this.userTimeline = new Post[MAX_TIMELINE];
        this.totalPosts = 0;
        this.totalFollowers = 0;
        this.totalTimeline = 0;
    }

    public void publish(String quote) {
        if (totalPosts >= MAX_POST) {
            System.out.println("You have reached the maximum number of posts.");
            return;
        }

        Post newPost = new Post(this, quote);
        userPosts[totalPosts++] = newPost;

        for (int i = 0; i < totalFollowers; i++) {
            if (userFollowers[i] != null) {
                userFollowers[i].updateTimeline(newPost);
            }
        }
    }

    public boolean delete(int postIdx) {
        if (postIdx < 0 || postIdx >= totalPosts) { return false; }

        for (int i = postIdx; i < totalPosts - 1; i++) {
            userPosts[i] = userPosts[i + 1];
        }

        totalPosts--;
        return true;
    }

    public String showTimeline() {
        if (totalTimeline == 0) {
            return "Your timeline is empty.";
        }

        StringBuilder timeline = new StringBuilder();
        for (int i = 0; i < totalTimeline; i++) {
            if (userTimeline[i] != null) {
                timeline.append(i + 1).append(". ").append(userTimeline[i].show()).append("\n");
            }
        }
        return timeline.toString();
    }

    public String showMyPosts() {
        if (totalPosts == 0) {
            return "You have no posts.";
        }

        StringBuilder myPosts = new StringBuilder();
        for (int i = 0; i < totalPosts; i++) {
            myPosts.append(i + 1).append(". ").append(userPosts[i].show()).append("\n");
        }
        return myPosts.toString();
    }

    public String showMyFriends() {
        if (totalFollowers == 0) {
            return "You have no followers.";
        }

        StringBuilder followers = new StringBuilder();
        for (int i = 0; i < totalFollowers; i++) {
            if (userFollowers[i] != null) {
                followers.append(i + 1).append(". ").append(" User: ").append(userFollowers[i].getUserName()).append("\n");
            }
        }
        return followers.toString();
    }

    public void clapPost(int postIdx) {
        if (postIdx < 0 || postIdx >= totalPosts || userPosts[postIdx] == null) {
            System.out.println("Invalid post index.");
            return;
        }
        userPosts[postIdx].clap();
    }

    public void booPost(int postIdx) {
        if (postIdx < 0 || postIdx >= totalPosts || userPosts[postIdx] == null) {
            System.out.println("Invalid post index.");
            return;
        }
        userPosts[postIdx].boo();
    }

    public void updateTimeline(Post newPost) {
        if (newPost == null) return;

        if (totalTimeline < MAX_TIMELINE) {
            userTimeline[totalTimeline++] = newPost;
        } else {
            for (int i = 0; i < MAX_TIMELINE - 1; i++) {
                userTimeline[i] = userTimeline[i + 1];
            }
            userTimeline[MAX_TIMELINE - 1] = newPost;
        }
    }

    public void acceptFollower(UserAccount newFollower) {
        if (newFollower == null || totalFollowers >= MAX_FOLLOWERS) return;
        userFollowers[totalFollowers++] = newFollower;
    }

    public void blockFollower(UserAccount follower) {
        if (follower == null || totalFollowers == 0) return;

        int followerIdx = -1;
        for (int i = 0; i < totalFollowers; i++) {
            if (userFollowers[i] == follower) {
                followerIdx = i;
                break;
            }
        }

        if (followerIdx == -1) return;

        for (int i = followerIdx; i < totalFollowers - 1; i++) {
            userFollowers[i] = userFollowers[i + 1];
        }

        userFollowers[--totalFollowers] = null;
    }
}