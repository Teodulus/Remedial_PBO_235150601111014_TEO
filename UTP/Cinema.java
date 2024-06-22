import java.util.ArrayList;

public class Cinema {
    private String name;
    private ArrayList<User> listUsers;
    private ArrayList<Studio> listStudios;
    private int studioCapacity;

    public Cinema(String name, int studioCapacity) {
        this.name = name;
        this.studioCapacity = studioCapacity;
        this.listUsers = new ArrayList<>();
        this.listStudios = new ArrayList<>();
        init();
    }

    public boolean registerUser(String email, String password, String fullName) {
        for (User user : listUsers) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        listUsers.add(new User(email, password, fullName));
        return true;
    }

    public User authenticateUser(String email, String password) {
        for (User user : listUsers) {
            if (user.isMatch(email, password)) {
                return user;
            }
        }
        return null;
    }

    public void displayListStudio() {
        for (int i = 0; i < listStudios.size(); i++) {
            Studio studio = listStudios.get(i);
            System.out.println("Studio " + (i + 1) + ": " + studio.getType() + " - " + studio.getMovie().getTitle());
        }
    }

    public void displayStudioDetail(int studioNumber) {
        if (studioNumber >= 1 && studioNumber <= listStudios.size()) {
            Studio studio = listStudios.get(studioNumber - 1);
            System.out.println(studio.getStudioInfo());
        } else {
            System.out.println("Invalid studio number");
        }
    }

    public boolean addStudioWithMovies(String type, String title, double rating, String[] genres) {
        if (listStudios.size() < studioCapacity) {
            listStudios.add(new Studio(type, new Movie(title, rating, genres)));
            return true;
        }
        return false;
    }

    public boolean bookTicket(User user, int studioNumber, int row, int col) {
        if (studioNumber >= 1 && studioNumber <= listStudios.size()) {
            Studio studio = listStudios.get(studioNumber - 1);
            if (!studio.isBooked(row, col) && user.getBalance() >= studio.getTicketPrice()) {
                studio.reserve(row, col);
                Ticket ticket = new Ticket(studio.getMovie(), studioNumber, studio.getTicketPrice());
                user.addTicket(ticket);
                user.deductBalance(studio.getTicketPrice());
                return true;
            }
        }
        return false;
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            addStudioWithMovies("Imax", "Movie " + (i + 1), 8.0 + i % 3, new String[]{"Genre" + (i + 1)});
        }
    }
}
