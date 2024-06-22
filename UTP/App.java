import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Starry Cinema", 10);
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Top Up Saldo");
            System.out.println("4. Display List Studio");
            System.out.println("5. Display Studio Detail");
            System.out.println("6. Book Ticket");
            System.out.println("7. Display All Tickets");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Full Name: ");
                    String fullName = scanner.nextLine();
                    if (cinema.registerUser(email, password, fullName)) {
                        System.out.println("Registration successful");
                    } else {
                        System.out.println("Registration failed, email already exists");
                    }
                    break;
                case 2:
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    currentUser = cinema.authenticateUser(email, password);
                    if (currentUser != null) {
                        System.out.println("Login successful");
                    } else {
                        System.out.println("Login failed, check your email and password");
                    }
                    break;
                case 3:
                    if (currentUser != null) {
                        System.out.print("Top up amount: ");
                        int amount = scanner.nextInt();
                        currentUser.addBalance(amount);
                        System.out.println("Top up successful, new balance: " + currentUser.getBalance());
                    } else {
                        System.out.println("Please login first");
                    }
                    break;
                case 4:
                    cinema.displayListStudio();
                    break;
                case 5:
                    System.out.print("Studio Number: ");
                    int studioNumber = scanner.nextInt();
                    cinema.displayStudioDetail(studioNumber);
                    break;
                case 6:
                    if (currentUser != null) {
                        System.out.print("Studio Number: ");
                        studioNumber = scanner.nextInt();
                        System.out.print("Row: ");
                        int row = scanner.nextInt();
                        System.out.print("Col: ");
                        int col = scanner.nextInt();
                        if (cinema.bookTicket(currentUser, studioNumber, row, col)) {
                            System.out.println("Ticket booked successfully");
                        } else {
                            System.out.println("Failed to book ticket");
                        }
                    } else {
                        System.out.println("Please login first");
                    }
                    break;
                case 7:
                    if (currentUser != null) {
                        currentUser.displayAllTickets();
                    } else {
                        System.out.println("Please login first");
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
