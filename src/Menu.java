import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    public static List<String> arrayOfContacts = new ArrayList<>();
    public static ReadWrite contacts = new ReadWrite("data","contacts.txt");

    public static void main(String[] args) {
        arrayOfContacts = contacts.getContacts();
        mainMenu();
    }


    public static void mainMenu() {
        System.out.println("Enter a number to perform the following task: ");
        System.out.println("0: quit");
        System.out.println("1: see all contacts");
        System.out.println("2: add a contact");
        System.out.println("3: search contact by name");
        System.out.println("4: delete contacts");

        parseAnswer(sc.nextLine());

    }

    public static void parseAnswer(String answer) {
        switch (answer) {
            case "0":
                break;
            case "1":
                showAll();
                goHome();
                break;
            case "2":
                Contact newContact = new Contact();
                arrayOfContacts.add(newContact.getFirstName()+"|"+newContact.getLastName()+"|"+newContact.getPhoneNumber());
                contacts.WriteContacts(arrayOfContacts);
                goHome();
                break;
            case "3":
                goHome();
                break;
            case "4":
                goHome();
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
         public static void searchContact(String input){
                for(String contact: arrayOfContacts){
                    String[] splitContact = contact.split("|",3);
                    if(input.equalsIgnoreCase(splitContact[0])){
                        System.out.println(contact);
                    }
                }
         }

         public static void goHome(){
             System.out.println("Press any key to return to main menu");
             sc.nextLine();
             mainMenu();
         }

    }
