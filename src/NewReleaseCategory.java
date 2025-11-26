public class NewReleaseCategory extends MovieCategory {

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented * 3;
    }

    // ALTERAÇÃO DO COMMIT 15
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}