import java.util.ArrayList;
import java.util.List;

public class Bot {
    User specialUser;

    public Bot() {
        specialUser = new User("rocket.cat", "Rocket.Cat");
    }

    public String getUserName () {
        return specialUser.getUsername();
    }

    public User getBot() {
        return specialUser;
    }

    public void analyseLastMessage(Channel channel, Message message) {

        String messageAnalysed = message.getMessage().toLowerCase();
        String increasedNotifications = "`";
        List<String> greetings = new ArrayList<>();

        greetings.add("Hi");
        greetings.add("Hi,");
        greetings.add("Hello");
        greetings.add("Hello,");


        if(!message.getAuthor().getUsername().equals("rocket.cat")) {
            for (String greeting : greetings) {
                if (messageAnalysed.startsWith(greeting.toLowerCase())) {
                    Message welcomeMessage = new Message(specialUser, "Howdy, " + message.getAuthor().getFullName());
                    channel.addMessage(welcomeMessage);
                }
            }

            if(messageAnalysed.contains(increasedNotifications + "all")) {
                for (User user : channel.getUsersInChannel()) {
                    user.incrementUnreadMessages();
                }
            }

            for(User user: channel.getUsersInChannel()) {
                if (messageAnalysed.contains(increasedNotifications+user.getUsername())) {
                    user.incrementUnreadMessages();
                }
            }

        }

    }

}
