public class Movie {

    private String title;
    private MovieCategory category;

    public Movie(String title, MovieCategory category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double calculateCharge(int daysRented) {
        return category.calculateCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return category.getFrequentRenterPoints(daysRented);
    }
}
