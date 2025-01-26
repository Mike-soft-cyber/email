import java.util.Scanner;

public class Email {
    private String dep;
    private String pass;
    private int passLength = 10;
   private String firstName;
    private String lastName;
    private int mailboxCap = 300;
    private String email;
    private String otherEmail;

    public Email(String first, String last){
        firstName = first;
        lastName = last;
        System.out.println("Email Created:"+first + " " +last);

        dep = Department();

        pass = generatePass(8);
        System.out.println("Your password is:"+pass);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + dep + ".com";
        System.out.println("Email: "+email);
    }

    private String Department() {
        System.out.println("Enter the Department:\n1. Sales\n2. Development\n3. Accounting\n0. None");
        System.out.print("Dep:");

        Scanner choice = new Scanner(System.in);
        int depChoice = choice.nextInt();
        choice.close();

        if (depChoice == 1){
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acc";
        }else {
            return "";
        }
    }

    private String generatePass(int length){
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$%!@#";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passSet.length());
            password[i] = passSet.charAt(rand);
        }
        return new String(password);
    }

    public void altEmail(String em){
        otherEmail = em;
    }

    public void changePass(String altPass){
        pass = altPass;
    }

    public void showInfo() {
        System.out.println("DISPLAY NAME: "+firstName + " " + lastName);
        System.out.println("COMPANY EMAIL: "+email);
        System.out.println("MAILBOX CAPACITY: "+mailboxCap + "MB");
    }
}
