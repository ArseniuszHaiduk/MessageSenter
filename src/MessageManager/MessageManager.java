package MessageManager;

import ConsoleManager.ConsoleManager;
import FileManager.FileManager;
import MessageData.MessageData;
import java.time.LocalTime;

public class MessageManager implements IMessageManager{
    ConsoleManager consoleManager = new ConsoleManager();
    FileManager fileManager = new FileManager();
    MessageData messageData = new MessageData();

    String messages = "core/messages.txt";
    String loginPath = "core/login.txt";

    public boolean SendMessage() {
        messageData.userName = fileManager.Read(loginPath);
        consoleManager.Print(messageData.userName + ":");

        String input = consoleManager.ReadString();
        if(input.equals("/exit")){
            return false;
        }
        messageData.messageContent = input;

        LocalTime time = LocalTime.now();

        messageData.messageTime = time.withNano(0).withSecond(0).toString();
        consoleManager.PrintLine("\b" + "(" + messageData.messageTime + ")");
        consoleManager.PrintLine("");

        fileManager.Save(messages, messageData.Message());
        return true;
    }

    public void ReadMessage() {
        fileManager.ReadMessages(messages);
        consoleManager.PrintLine("");
    }
}
