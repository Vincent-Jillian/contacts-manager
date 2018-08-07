import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
    private List<String> readString;
    private String directory;
    private String filename;
    private Path listOfContactsPath = Paths.get(directory,filename );

    public ReadWrite(){}

    public List<String> getContacts(){
        try {
            this.readString = Files.readAllLines(listOfContactsPath);
        } catch (Exception e){
            readString.add(e.toString());
        }
        return readString;
    }

    public void WriteContacts(ArrayList<String> contacts){
        try {
            Files.write(listOfContactsPath, contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void AddContact(String contact){
//        try {
//            Files.write(listOfContactsPath, contact, StandardOpenOption.APPEND);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
