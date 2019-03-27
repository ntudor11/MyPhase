public class Message {

    private User author;
    private String message;

    public Message(User author, String message) {
        this.author = author;
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return author.getFullName() + ":" + "\n"+ message;
    }
}
