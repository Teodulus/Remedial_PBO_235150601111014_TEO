import java.util.ArrayList;

public class User {
    private String email;
    private String password;
    private String fullName;
    private int balance;
    private ArrayList<Ticket> ticketLists;
    private final int MAX_TICKET = 20;

    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.balance = 0;
        this.ticketLists = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public boolean isMatch(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void addTicket(Ticket ticket) {
        if (ticketLists.size() < MAX_TICKET) {
            ticketLists.add(ticket);
        }
    }

    public void displayAllTickets() {
        for (Ticket ticket : ticketLists) {
            System.out.println("Movie: " + ticket.getMovie().getTitle() + " | Studio: " + ticket.getStudioNumber() + " | Price: " + ticket.getPrice());
        }
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public void deductBalance(int amount) {
        balance -= amount;
    }
}
