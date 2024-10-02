package ConsoleManager;

import java.util.Scanner;

public class ConsoleManager implements IConsoleManager{
    Scanner scanner = new Scanner(System.in);

    public void PrintLine(String Text) {
        System.out.println(Text);
    }

    public void Print(String Text) {
        System.out.print(Text);
    }

    public String ReadString() {
        return scanner.nextLine();
    }
}
