public class Ticket {
    private Movie movie;
    private int studioNumber;
    private int price;

    public Ticket(Movie movie, int studioNumber, int price) {
        this.movie = movie;
        this.studioNumber = studioNumber;
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStudioNumber() {
        return studioNumber;
    }

    public int getPrice() {
        return price;
    }
}
