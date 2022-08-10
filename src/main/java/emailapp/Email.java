/**
 *  This is a modified version of the Master Skills channel's (https://www.youtube.com/channel/UCJDMU2Z2A70Yu3pVe_c-HYw)
 *  Email Administration Application exercise. The project has been converted to a Maven project and a test class has
 *  been added.
 */

package emailapp;

import java.util.Scanner;

/**
 * A class for creating and managing company e-mail accounts.
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    /**
     * Create an email address and password.
     */
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "."
                + this.companySuffix;
        System.out.println("Your email is: " + email);
    }

    /**
     * For testing.
     */
    public Email(String firstName, String lastName, String password, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.department = department;
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "."
                + this.companySuffix;
    }

    /**
     * Generates a random password.
     * @param length The length of the generated password.
     * @return String
     */
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomChar = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomChar);
        }
        return new String(password);
    }

    /**
     * Ask for the department.
     */
    private String setDepartment() {
        int depChoice = -1;
        while ((depChoice < 0) || (depChoice > 3)){
            System.out.println("New worker: " + firstName + " " + lastName + "\nSelect department code:\n1 for Sales" +
                    "\n2 for Development\n3 for Accounting\n0 for none");
            System.out.println("Enter department code: ");
            Scanner scanner = new Scanner(System.in);
            depChoice = scanner.nextInt();
        }
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return  "acct"; }
        else { return ""; }
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "Info: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mailboxCapacity=" + mailboxCapacity;
    }
}
