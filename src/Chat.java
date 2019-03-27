import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    private List<String> usersList = new ArrayList<>();
    private List<String> channelsList = new ArrayList<>();
    private List<User> joinedUsersList = new ArrayList<>();
    private Bot bot;

    public User createUser(String username, String fullName) {


        if(!usersList.contains(username)) {
            User userExample = new User(username, fullName);
            usersList.add(username);
            joinedUsersList.add(userExample);
            //System.out.println("the users inside the usersList are: " + usersList);
            return userExample;
        } else {
            System.out.println("User "+ username + " already exists!");
            return null;
        }
    }

    public Channel createChannel(String channelName) {

        Channel channel1 = new Channel(channelName);

        if(!channelsList.contains(channelName)) {
            channelsList.add(channelName);
            this.bot = new Bot();
            usersList.add(bot.getUserName());
            bot.getBot().joinChannel(channel1);
            joinedUsersList.add(bot.getBot());
            //System.out.println("The channels in the channelsList are " + channelsList.toString());
            return channel1;
        } else {
            System.out.println("Channel "+ channelName + " already exists!");
            return null;
        }
    }

    /*public void channelJoinCommand(User user, Channel channel){
        if(usersList.contains(user.getUsername())) {
            if(channelsList.contains(channel)) {
                joinedChannelsList.add(createChannel(channel.getChannelName()));
            } else {
                System.out.println("\nThe requested channel doesn't exist!");
            }
            //channel.onUserLeft(user);
            if (joinedUsersList.contains(user)) {
                joinedUsersList.add(createUser(user.getUsername(), user.getFullName()));

                //System.out.println("user was added: " + user.getUsername());
            }
            //System.out.println(user.getUsername() + " has joined the channel " + channel.getChannelName());
        } else {
            //System.out.println("user " + user.getUsername() + " is a fake user for channel: "+ channel.getChannelName() + ". Users of joinedUsersList inside: " + joinedUsersList);
            System.out.print("The requested user doesn't exist!");
        }

        /*if(!joinedUsersList.contains(createUser(user.getUsername(), user.getFullName()))) {
            System.out.println("The requested user doesn't exist!");
            joinedUsersList.add(createUser(user.getUsername(), user.getFullName()));
        } else {

        }
    }*/

    public void channelJoinCommand(User user, Channel channel) {
        if (!usersList.contains(user.getUsername())) {
            System.out.println("The requested user doesn't exist!");
        } else if(!channelsList.contains(channel.getChannelName())) {
            System.out.println("The requested channel doesn't exist!");
        } else if(usersList.contains(user.getUsername()) && !user.userCheckChannel(channel.getChannelName()) && !channel.channelCheckUser(user.getUsername())) {
            user.joinChannel(channel);
            joinedUsersList.add(user);
        }
    }

    public void channelLeaveCommand(User user, Channel channel) {
        if(!usersList.contains(user.getUsername())) {
            System.out.println("The requested user doesn't exist!");
        } else if (!channelsList.contains(channel.getChannelName())) {
            System.out.println("The requested channel doesn't exist!");
        } else if(usersList.contains(user.getUsername()) && user.userCheckChannel(channel.getChannelName()) && channel.channelCheckUser(user.getUsername())) {
            user.leaveChannel(channel);
            joinedUsersList.remove(user);
        }
    }

    public void postMessage(Channel channel, User user, String message) {
        if(!channelsList.contains(channel.getChannelName())) {
            System.out.println("The requested channel doesn't exist!");
        } else if (!user.userCheckChannel(channel.getChannelName())) {
            System.out.println("User " + user.getUsername() + " has not joined channel " + channel.getChannelName());
        } else {
            Message message1 = new Message(user, message);
            channel.addMessage(message1);
            bot.analyseLastMessage(channel, message1);
        }
    }

    public void printChannelMessages(Channel channel) {
        System.out.println("Messages in " + channel.getChannelName() + ":");
        for(User user : channel.getUsersInChannel()) {

            if(!user.getUsername().equals(bot.getUserName())) {
                System.out.println(user.getFullName() + ":");
                System.out.println(user.getUsername() + " has joined the channel");
            }
        }

        for(Message message : channel.getMessages()) {
            System.out.println(message);
        }
    }
}
