import java.util.Scanner;

public class Contact{
    private Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    public Contact() {
        System.out.println("Please enter a first name");
        this.firstName = sc.nextLine();
        System.out.println("Please enter a last name");
        this.lastName = sc.nextLine();
        System.out.println("Please enter a ten-digit phone number");
        this.phoneNumber = sc.nextLine();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


