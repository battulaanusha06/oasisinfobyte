import java.util.*;

class Reservation {
    String name;
    int age;
    String trainNumber;
    String trainName;
    String classType;
    String from;
    String to;
    String date;
    String pnr;

    public Reservation(String name, int age, String trainNumber, String trainName,
                       String classType, String from, String to, String date, String pnr) {
        this.name = name;
        this.age = age;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.from = from;
        this.to = to;
        this.date = date;
        this.pnr = pnr;
    }
}

public class OnlineReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Reservation> reservations = new ArrayList<>();

    static String username = "admin";
    static String password = "1234";

    public static void main(String[] args) {

        if (login()) {
            int choice;
            do { 
                System.out.println("\n===== ONLINE RESERVATION SYSTEM =====");
                System.out.println("1. Make Reservation");
                System.out.println("2. Cancel Reservation");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        System.out.println("Thank You!");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            } while (choice != 3);
        } else {
            System.out.println("Invalid Login!");
        }
    }

    static boolean login() {
        System.out.println("===== LOGIN =====");
        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        return user.equals(username) && pass.equals(password);
    }

    static void makeReservation() {
        System.out.println("\n===== RESERVATION FORM =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Train Number: ");
        String trainNumber = sc.nextLine();

        String trainName = getTrainName(trainNumber);

        System.out.print("Enter Class Type (Sleeper/AC): ");
        String classType = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        System.out.print("Date of Journey: ");
        String date = sc.nextLine();

        String pnr = "PNR" + new Random().nextInt(10000);

        reservations.add(new Reservation(name, age, trainNumber, trainName,
                classType, from, to, date, pnr));

        System.out.println("Reservation Successful!");
        System.out.println("Your PNR Number: " + pnr);
    }

    static void cancelReservation() {
        System.out.print("\nEnter PNR Number: ");
        String pnrInput = sc.nextLine();

        for (Reservation r : reservations) {
            if (r.pnr.equals(pnrInput)) {
                System.out.println("Reservation Found:");
                System.out.println("Name: " + r.name);
                System.out.println("Train: " + r.trainName);
                System.out.println("From: " + r.from + " To: " + r.to);

                System.out.print("Confirm Cancellation? (yes/no): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    reservations.remove(r);
                    System.out.println("Reservation Cancelled Successfully!");
                }
                return;
            }
        }

        System.out.println("PNR Not Found!");
    }

    static String getTrainName(String trainNumber) {
        switch (trainNumber) {
            case "101":
                return "Express Train";
            case "102":
                return "Superfast Train";
            default:
                return "Local Train";
        }
    }
}