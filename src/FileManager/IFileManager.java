package FileManager;

public interface IFileManager {
    public void Save(String path, String Content);

    public String Read(String path);
}
