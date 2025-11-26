public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    // ---- NOVO NO COMMIT 5 ----
    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    // ---- NOVO NO COMMIT 5 ----
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
