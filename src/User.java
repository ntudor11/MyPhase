
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private String fullName;
    private List<Channel> joinedChannels;
    private int notifications;

    public User(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
        this.joinedChannels = new ArrayList<>();
        notifications = 0;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean joinChannel(Channel channel) {
        if(!joinedChannels.contains(channel)) {
            joinedChannels.add(channel);
            channel.onUserJoined(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean leaveChannel(Channel channel) {
        if (joinedChannels.contains(channel)) {
            joinedChannels.remove(channel);
            channel.onUserLeft(this);
            return true;
        } else {
            return false;
        }
    }

    public void printChannelsJoined() {
        System.out.println("User " + username + " has joined the following channels:");

        for(Channel channel : joinedChannels) {
            System.out.println(channel.getChannelName());
        }
    }

    public void incrementUnreadMessages() {
        notifications++;
    }

    public boolean userCheckChannel(String channelName) {
        for(Channel channel : joinedChannels) {
            if (channel.getChannelName() == channelName) {
                return true;
            }
        }
        return false;
    }

    public void onLogin() {

        System.out.println("Hi, " + fullName);
        System.out.println("You have " + notifications + " unread messages.");
        notifications = 0;
    }
}
