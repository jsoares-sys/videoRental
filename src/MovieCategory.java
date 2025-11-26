public abstract class MovieCategory {

    public abstract double calculateCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
