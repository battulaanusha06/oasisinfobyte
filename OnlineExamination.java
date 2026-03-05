import java.util.Scanner;

public class OnlineExamination {

    static String username = "anusha";
    static String password = "1234";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ONLINE EXAMINATION SYSTEM");

        System.out.print("Enter Username: ");
        String u = sc.next();

        System.out.print("Enter Password: ");
        String p = sc.next();

        if (u.equals(username) && p.equals(password)) {

            int choice;

            do {
                System.out.println("\n1. Start Exam");
                System.out.println("2. Update Profile and Password");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        startExam(sc);
                        break;

                    case 2:
                        updateProfile(sc);
                        break;

                    case 3:
                        System.out.println("Logout successful");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 3);

        } else {
            System.out.println("Invalid Login");
        }

        sc.close();
    }

    public static void startExam(Scanner sc) {

        int score = 0;

        System.out.println("\nExam Started");
        System.out.println("Time: 30 seconds\n");

        long start = System.currentTimeMillis();
        long limit = 30000;

        if (System.currentTimeMillis() - start < limit) {
            System.out.println("1. Which keyword is used to inherit a class in Java?");
            System.out.println("a) implements");
            System.out.println("b) extends");
            System.out.println("c) super");
            System.out.println("d) import");
            char ans = sc.next().charAt(0);
            if (ans == 'b') score++;
        }

        if (System.currentTimeMillis() - start < limit) {
            System.out.println("\n2. Which method is the entry point of Java program?");
            System.out.println("a) start()");
            System.out.println("b) main()");
            System.out.println("c) run()");
            System.out.println("d) init()");
            char ans = sc.next().charAt(0);
            if (ans == 'b') score++;
        }

        if (System.currentTimeMillis() - start < limit) {
            System.out.println("\n3. Which keyword is used to create an object?");
            System.out.println("a) new");
            System.out.println("b) class");
            System.out.println("c) object");
            System.out.println("d) make");
            char ans = sc.next().charAt(0);
            if (ans == 'a') score++;
        }

        if (System.currentTimeMillis() - start < limit) {
            System.out.println("\n4. Which data type stores decimal values?");
            System.out.println("a) int");
            System.out.println("b) char");
            System.out.println("c) double");
            System.out.println("d) boolean");
            char ans = sc.next().charAt(0);
            if (ans == 'c') score++;
        }

        if (System.currentTimeMillis() - start < limit) {
            System.out.println("\n5. Which loop executes at least once?");
            System.out.println("a) for");
            System.out.println("b) while");
            System.out.println("c) do-while");
            System.out.println("d) none");
            char ans = sc.next().charAt(0);
            if (ans == 'c') score++;
        }

        if (System.currentTimeMillis() - start >= limit) {
            System.out.println("\nTime up! Exam auto submitted");
        }

        System.out.println("\nScore: " + score + "/5");
    }

    public static void updateProfile(Scanner sc) {

        System.out.print("Enter new username: ");
        username = sc.next();

        System.out.print("Enter new password: ");
        password = sc.next();

        System.out.println("Profile updated");
    }
}