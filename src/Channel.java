import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String channelName;
    private List<User> usersList;
    private List<Message> messagesList;

    public Channel(String channelName) {
        this.channelName = channelName;
        this.usersList = new ArrayList<>();
        this.messagesList = new ArrayList<>();
    }

    public String getChannelName() {
        return channelName;
    }

    public List<User> getUsersInChannel() {
        return usersList;
    }

    public List<Message> getMessages() {
        return messagesList;
    }

    public void onUserJoined(User user) {
        if(!usersList.contains(user)) {
            usersList.add(user);
        }
    }

    public void onUserLeft(User user) {
        if(usersList.contains(user)) {
            usersList.remove(user);
        }
    }

    public boolean addMessage(Message message) {
        if(usersList.contains(message.getAuthor())) {
            messagesList.add(message);
            return true;
        } else {
            return false;
        }
    }

    public boolean channelCheckUser(String username) {
        for(User user : usersList) {
            if(user.getUsername() == username) {
                return true;
            }
        }
        return false;
    }
}




