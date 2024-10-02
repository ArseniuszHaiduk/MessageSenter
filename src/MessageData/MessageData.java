package MessageData;

public class MessageData {
    public String userName;

    public String messageContent;

    public String messageTime;

    public String Message(){
        return userName + ":" + messageContent + "(" + messageTime + ")";
    }
}
