package UserManager;

import ConsoleManager.ConsoleManager;
import FileManager.FileManager;
import UserData.UserData;

public class UserManager implements IUserManager{
    ConsoleManager consoleManager = new ConsoleManager();
    StringBuilder stringBuilder = new StringBuilder();
    UserData userData = new UserData();
    FileManager fileManager = new FileManager();

    String loginPath = "core/login.txt";
    String passwordPath = "core/password.txt";

    public boolean Login() {
        boolean loginStatus = false;
        boolean passwordStatus = false;

        while(true){
            //Login
            consoleManager.Print("Username:");
            String login = consoleManager.ReadString();
            if(login.equals("/exit")){
                break;
            }

            for(char c : login.toCharArray()){
                stringBuilder.append(c);
            }
            if((stringBuilder.toString()).equals(fileManager.Read(loginPath))){
                loginStatus = true;
            }
            stringBuilder.delete(0, stringBuilder.length());

            //Password
            consoleManager.Print("Password:");
            String password = consoleManager.ReadString();
            if(password.equals("/exit")){
                break;
            }

            for(char c : password.toCharArray()){
                stringBuilder.append(c);
            }
            if((stringBuilder.toString()).equals(fileManager.Read(passwordPath))){
                passwordStatus = true;
            }
            stringBuilder.delete(0, stringBuilder.length());

            if(loginStatus && passwordStatus){
                return true;
            }
            else{
                consoleManager.PrintLine("Login or password is incorrect");
            }
        }
        return false;
    }

    public void Register() {
        consoleManager.Print("Username: ");
        userData.Login = consoleManager.ReadString();
        consoleManager.Print("Password: ");
        userData.Password = consoleManager.ReadString();

        fileManager.Save(loginPath, userData.Login);
        fileManager.Save(passwordPath, userData.Password);
    }
}
