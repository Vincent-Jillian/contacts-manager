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

    public ReadWrite(String directory, String filename) {
        this.directory = directory;
        this.filename = filename;
    }

    public ReadWrite(){}

    public List<String> getContacts(){
        try {
            this.readString = Files.readAllLines(listOfContactsPath);
        } catch (Exception e){
            readString.add(e.toString());
        }
        return readString;
    }

    public void WriteContacts(ArrayList<String> contact){
        try {
            Files.write(listOfContactsPath, contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getReadString() {
        return readString;
    }

    public void setReadString(List<String> readString) {
        this.readString = readString;
    }

    public Path getListOfContactsPath() {
        return listOfContactsPath;
    }

    public void setListOfContactsPath(Path listOfContactsPath) {
        this.listOfContactsPath = listOfContactsPath;
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

    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite("../data", "test.txt");
        readWrite.setDirectory("../data");
        readWrite.setFilename("test.txt");
        System.out.println(readWrite.getFilename());
        Path testPath = Paths.get("../data", "test.txt");
        System.out.println(Files.exists(testPath));
    }
}
