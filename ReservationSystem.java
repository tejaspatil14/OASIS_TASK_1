import java.util.Scanner;

public class ReservationSystem {
    private boolean[] seats;
    private boolean loggedIn;
    private String username;

    public ReservationSystem(int numSeats) {
        seats = new boolean[numSeats];
        loggedIn = false;
        username = "";
    }

    public boolean login(String username, String password) {

        if (username.equals("admin") && password.equals("password")) {
            loggedIn = true;
            this.username = username;
            return true;
        } else {
            loggedIn = false;
            this.username = "";
            return false;
        }
    }

    public void reserveSeat(int seatNumber, String trainNumber, String classType, String dateOfJourney, String from,
            String to) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Reservation Details:");
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Seat Number: " + seatNumber);

        String pnrNumber = generatePNR();
        System.out.println("PNR Number: " + pnrNumber);
    }

    public void cancelTicket(String pnrNumber) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("Cancellation Details for PNR Number: " + pnrNumber);

        System.out.print("Press OK to confirm the cancellation: ");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("OK")) {

            System.out.println("Ticket with PNR Number " + pnrNumber + " has been cancelled successfully.");
        } else {
            System.out.println("Cancellation not confirmed.");
        }
    }

    private String generatePNR() {

        return "ABC123";
    }

    public void displayAvailableSeats() {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seats: ");
        int numSeats = scanner.nextInt();

        ReservationSystem reservationSystem = new ReservationSystem(numSeats);

        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        if (reservationSystem.login(username, password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password. Exiting...");
            System.exit(0);
        }

        System.out.print("Enter the train number: ");
        String trainNumber = scanner.next();

        System.out.print("Enter the class type: ");
        String classType = scanner.next();

        System.out.print("Enter the date of journey: ");
        String dateOfJourney = scanner.next();

        System.out.print("Enter the starting place: ");
        String from = scanner.next();

        System.out.print("Enter the destination: ");
        String to = scanner.next();

        System.out.print("Enter the seat number: ");
        int seatNumber = scanner.nextInt();

        reservationSystem.reserveSeat(seatNumber, trainNumber, classType, dateOfJourney, from, to);
        System.out.println("----------------------------------------------------------------");
        System.out.print("Enter the PNR number to cancel the ticket: ");
        String pnrNumber = scanner.next();
        reservationSystem.cancelTicket(pnrNumber);

    }

}
