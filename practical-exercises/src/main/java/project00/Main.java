package project00;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserAccount user1 = new UserAccount("user1@example.com", "user1");
        UserAccount user2 = new UserAccount("user2@example.com", "user2");
        UserAccount user3 = new UserAccount("user3@example.com", "user3");

        user1.acceptFollower(user2);
        user1.acceptFollower(user3);

        while (true) {
            System.out.println("---- Welcome to the Social Media App ----");
            System.out.println("Choose an option:");
            System.out.println("1. Publish a post");
            System.out.println("2. Show my timeline");
            System.out.println("3. Show my posts");
            System.out.println("4. Show my followers");
            System.out.println("5. Clap a post");
            System.out.println("6. Boo a post");
            System.out.println("7. Delete a post");
            System.out.println("8. Block a follower");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the content of your post: ");
                    String content = scanner.nextLine();
                    user1.publish(content);
                    System.out.println("Post published!");
                    break;

                case 2:
                    System.out.println("Your timeline: ");
                    System.out.println(user1.showTimeline());
                    break;

                case 3:
                    System.out.println("Your posts: ");
                    System.out.println(user1.showMyPosts());
                    break;

                case 4:
                    System.out.println("Your followers: ");
                    System.out.println(user1.showMyFriends());
                    break;

                case 5:
                    System.out.print("Select a post to clap: ");
                    int postIdxClap = scanner.nextInt() - 1;
                    scanner.nextLine();
                    user1.clapPost(postIdxClap);
                    System.out.println("You clapped the post!");
                    break;

                case 6:
                    System.out.print("Select a post to boo: ");
                    int postIdxBoo = scanner.nextInt() - 1;
                    user1.booPost(postIdxBoo);
                    System.out.println("You booed the post!");
                    break;

                case 7:
                    System.out.print("Select a post to delete: ");
                    int postIdxDelete = scanner.nextInt();
                    if (user1.delete(postIdxDelete)) {
                        System.out.println("Post deleted successfully!");
                    } else {
                        System.out.println("Invalid post index!");
                    }
                    break;

                case 8:
                    System.out.print("Enter the username of the follower to block: ");
                    String followerName = scanner.nextLine();
                    UserAccount toBlock = null;
                    for (UserAccount follower : user1.getFollowers()) {
                        if (follower != null && follower.getUserName().equals(followerName)) {
                            toBlock = follower;
                            break;
                        }
                    }
                    if (toBlock != null) {
                        user1.blockFollower(toBlock);
                        System.out.println("Follower blocked successfully!");
                    } else {
                        System.out.println("Follower not found!");
                    }
                    break;

                case 9:
                    System.out.println("Exiting the app. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}