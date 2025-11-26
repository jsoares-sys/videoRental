public abstract class MovieCategory {

    public abstract double calculateCharge(int daysRented);

    // NOVO NO COMMIT 15
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}