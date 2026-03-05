import java.util.Scanner;

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userId = "1234";
        int userPin = 1111;
        double balance = 5000.0;

        System.out.println("Welcome to ATM");

        System.out.print("Enter User ID: ");
        String enteredId = sc.next();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredId.equals(userId) && enteredPin == userPin) {

            int choice;

            do {
                System.out.println("\n---- ATM MENU ----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Your Balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();
                        balance += deposit;
                        System.out.println("Deposit Successful!");
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw <= balance) {
                            balance -= withdraw;
                            System.out.println("Withdrawal Successful!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for using ATM!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 4);

        } else {
            System.out.println("Invalid User ID or PIN!");
        }

        sc.close();
    }
}