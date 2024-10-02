import ChoiceManager.ChoiceManager;
import ConsoleManager.ConsoleManager;

public class Main {
    public static void main(String[] args){
        ConsoleManager consoleManager = new ConsoleManager();
        ChoiceManager choiceManager = new ChoiceManager();

        while(true){
            consoleManager.PrintLine("Welcome to the Forum Platform!");
            consoleManager.PrintLine("Please, choose one from the next options:");
            consoleManager.PrintLine("1)Login\n2)Register\n3)Commands\n4)Exit");
            choiceManager.MakeChoice();
        }
    }
}
