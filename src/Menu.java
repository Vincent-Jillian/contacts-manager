import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> arrayOfContacts = new ArrayList<>();
    public static ReadWrite contacts = new ReadWrite("data","contacts.txt");

    public static void main(String[] args) {
        arrayOfContacts.addAll(contacts.getContacts());
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
                System.out.println("Please enter the name you would like to search.");
                String input = sc.nextLine();
                searchContact(input);
                goHome();
                break;
            case "4":
                System.out.println("Enter the name you would like to delete");
                deleteFeature(sc.nextLine());
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
                    String[] splitContact = contact.split("\\|",-1);
//                    for(String part: splitContact){
//                        System.out.println(part);
//                    }
                    if(input.equalsIgnoreCase(splitContact[0])){
                        System.out.println(contact);
                    }
                }
         }

         public static void deleteFeature(String input){
            ArrayList<Integer>numberList = new ArrayList<>();
            int counter = 0;

             for(String contact: arrayOfContacts){
                 String[] splitContact = contact.split("\\|",-1);
//                    for(String part: splitContact){
//                        System.out.println(part);
//                    }
                 if(input.equalsIgnoreCase(splitContact[0])){
                     numberList.add(counter);
                 }
                 counter++;
             }
             for(int index: numberList){
                 System.out.println("id: "+index+" "+arrayOfContacts.get(index));
             }
             System.out.println("please enter the id of the contact you would like to delete:");
            try {
                arrayOfContacts.remove(sc.nextInt());
                for(String contact: arrayOfContacts){
                    System.out.println("undeleted contact: "+contact);
                }
//                contacts.WriteContacts(arrayOfContacts);
//                System.out.println("Contact deleted");

            } catch (Exception e){
                System.out.println("Unable to delete");
            }
         }

         public static void goHome(){
             System.out.println("Press any key to return to main menu");
             sc.nextLine();
             mainMenu();
         }

    }
