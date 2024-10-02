package FileManager;

import java.io.*;

public class FileManager implements IFileManager {

    StringBuilder stringBuilder = new StringBuilder();

    public void Save(String path, String content) {
        try {
            File file = new File(path);

            if(file.canExecute()){
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

                bufferedWriter.write("\n" + content);
                bufferedWriter.close();

            }
            else{
                file.createNewFile();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));

                bufferedWriter.write(content);
                bufferedWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadMessages(String path) {
        try{
            File file = new File(path);

            if(file.canExecute()){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

                String l;
                stringBuilder.delete(0, stringBuilder.length());
                while((l = bufferedReader.readLine()) != null){
                    System.out.println(l);
                }
            }
            else{
                System.out.println("Error, " + path + " not found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String Read(String path) {
        try{
            File file = new File(path);

            if(file.canExecute()){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

                String l;
                stringBuilder.delete(0, stringBuilder.length());
                while((l = bufferedReader.readLine()) != null){
                    for(char c : l.toCharArray()){
                        stringBuilder.append(c);
                    }
                    return stringBuilder.toString();
                }
            }
            else{
                System.out.println("Error, " + path + " not found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "There are no messages here:(";
    }
}
