public class MyPhase {

    public static void main(String[] args) {
        User u1,u2,u3,trbj,wilr,ivml,vlli,lisj,saram,mdho,sahu;
        Channel c1,c2;
        Message m1,m2;
        Chat chat;
        chat = new Chat();
        c1 = chat.createChannel("gp-autumn-2018-ta");
        trbj = chat.createUser("trbj", "Troels Bjerre Lund");
        chat.channelJoinCommand(trbj, c1);
        chat.postMessage(c1, trbj, "Hi");
        chat.postMessage(c1, trbj, "Hello Rocket Cat! Have you seen the TAs?");
        chat.postMessage(c1, trbj, "... guess not");
        chat.printChannelMessages(c1);

    }


    /*public static void main(String[] args) {
        Chat chat1 = new Chat();
        User user1 = new User("tuna", "Tudor Nastasa");
        User user2 = new User("kris", "Kristofer");
        User u2;
        u2 = chat1.createUser("felis", "Felicia");
        Channel channel1 = new Channel("GP autumn");
        Channel channel2 = new Channel("Maff");
        Channel channel3;


        Message message0 = new Message(user1, "Hello");

       /* user1.joinChannel(channel1);
        user1.joinChannel(channel2);
        user1.printChannelsJoined();
        System.out.println();
        channel1.addMessage(message0);
        //chat1.createUser("tunas", "tNastasa");



        channel3 = chat1.createChannel("TV3");
        Channel channel4 = chat1.createChannel("TV4");


        User u3 = chat1.createUser("frosu", "Felicitas");
        chat1.channelJoinCommand(user1, channel2);
        chat1.channelLeaveCommand(user1, channel2);
        chat1.channelJoinCommand(u3, channel4);
        chat1.channelJoinCommand(u3, channel2);

        //chat1.channelLeaveCommand(user1, channel2);
        //chat1.channelLeaveCommand(user1, channel2);


    }*/
}
