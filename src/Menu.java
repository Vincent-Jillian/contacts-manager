import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static List<String> arrayOfContacts = new ArrayList<>();

    public static void main(String[] args) {
        List getList = new ReadWrite().getContacts();
        arrayOfContacts = getList;


    }


    public static void mainMenu() {
        System.out.println("Enter a number to perform the following task: ");
        System.out.println("1: see all contacts");
        System.out.println("2: add a contact");
        System.out.println("3: search contact by name");
        System.out.println("4: delete contacts");

        parseAnswer(sc.nextLine());

    }

    public static void(String answer) {
        switch (answer) {
            case "1":
                showAll();
                break;
            case "2":
                Contact newContact = new Contact();
                arrayOfContacts.add(newContact.getFirstName()+"|"+newContact.getLastName()+"|"+newContact.getPhoneNumber());
                break;
            case "3":
                break;
            case "4":
                 break;
            default:
                   System.out.println("That was not an option.");
                   mainMenu();

            }
        }
        public static void showAll() {
            for(String contact: arrayOfContacts){
                System.out.println(contact);

            }

         }

    }
