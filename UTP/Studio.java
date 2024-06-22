public class Studio {
    private Movie movie;
    private String type;
    private boolean[][] seats;

    public Studio(String type, Movie movie) {
        this.type = type;
        this.movie = movie;
        setSeats();
    }

    public boolean isBooked(int row, int col) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            return false;
        }
        return seats[row][col];
    }

    public String getStudioInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Movie: ").append(movie.getTitle()).append("\n");
        info.append("Type: ").append(type).append("\n");
        info.append("Ticket Price: ").append(getTicketPrice()).append("\n");
        info.append("Seats:\n");
        for (boolean[] row : seats) {
            for (boolean seat : row) {
                info.append(seat ? "X " : "O ");
            }
            info.append("\n");
        }
        return info.toString();
    }

    public boolean reserve(int row, int col) {
        if (!isBooked(row, col)) {
            seats[row][col] = true;
            return true;
        }
        return false;
    }

    private void setSeats() {
        switch (type) {
            case "Imax":
                seats = new boolean[8][9];
                break;
            case "Premiere":
                seats = new boolean[6][4];
                break;
            case "Reguler":
                seats = new boolean[5][5];
                break;
            default:
                seats = new boolean[0][0];
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public String getType() {
        return type;
    }

    public int getTicketPrice() {
        switch (type) {
            case "Premiere":
                return 120000;
            case "Imax":
                return 100000;
            case "Reguler":
                return 50000;
            default:
                return 0;
        }
    }
}
