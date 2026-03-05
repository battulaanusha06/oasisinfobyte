import java.util.Scanner;

public class DigitalLibrary {

    static String[] books = new String[10];
    static boolean[] issued = new boolean[10];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nDIGITAL LIBRARY");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    adminMenu(sc);
                    break;

                case 2:
                    userMenu(sc);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 3);

        sc.close();
    }

    public static void adminMenu(Scanner sc) {

        int choice;

        do {
            System.out.println("\nADMIN MENU");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    if (count < books.length) {
                        System.out.print("Enter book name: ");
                        books[count] = sc.nextLine();
                        issued[count] = false;
                        count++;
                        System.out.println("Book added");
                    } else {
                        System.out.println("Library is full");
                    }
                    break;

                case 2:
                    viewBooks();
                    break;

            }

        } while (choice != 3);
    }

    public static void userMenu(Scanner sc) {

        int choice;

        do {
            System.out.println("\nUSER MENU");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewBooks();
                    break;

                case 2:
                    viewBooks();
                    System.out.print("Enter book number to issue: ");
                    int i = sc.nextInt();

                    if (i >= 0 && i < count) {
                        if (!issued[i]) {
                            issued[i] = true;
                            System.out.println("Book issued");
                        } else {
                            System.out.println("Book already issued");
                        }
                    } else {
                        System.out.println("Invalid book number");
                    }
                    break;

                case 3:
                    viewBooks();
                    System.out.print("Enter book number to return: ");
                    int r = sc.nextInt();

                    if (r >= 0 && r < count) {
                        if (issued[r]) {
                            issued[r] = false;
                            System.out.println("Book returned");
                        } else {
                            System.out.println("This book was not issued");
                        }
                    } else {
                        System.out.println("Invalid book number");
                    }
                    break;

            }

        } while (choice != 4);
    }

    public static void viewBooks() {

        if (count == 0) {
            System.out.println("No books available");
            return;
        }

        System.out.println("\nBOOK LIST");

        for (int i = 0; i < count; i++) {

            if (issued[i]) {
                System.out.println(i + " - " + books[i] + " (Issued)");
            } else {
                System.out.println(i + " - " + books[i] + " (Available)");
            }

        }
    }
}