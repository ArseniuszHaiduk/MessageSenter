package ChoiceManager;

import ConsoleManager.ConsoleManager;
import MessageManager.MessageManager;
import UserManager.UserManager;

public class ChoiceManager {
    ConsoleManager consoleManager = new ConsoleManager();
    UserManager userManager = new UserManager();
    MessageManager messageManager = new MessageManager();

    public void MakeChoice(){
        try{
            switch(Integer.parseInt(consoleManager.ReadString())){
                case 1:
                    if(!userManager.Login()){
                        break;
                    }

                    messageManager.ReadMessage();

                    boolean chattingStatus = true;
                    while(chattingStatus){
                        chattingStatus = messageManager.SendMessage();
                    }
                    break;

                case 2:
                    userManager.Register();
                    break;

                case 3:
                    consoleManager.PrintLine("Type /exit to end an operation.");
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    consoleManager.PrintLine("Please, choose the correct option.");
                    break;
            }
        }
        catch (Exception exception){
            consoleManager.PrintLine("Please, choose the correct option. For example: 1");
        }
    }
}
