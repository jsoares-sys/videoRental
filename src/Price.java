public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    // Commit 13 — novo método
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
