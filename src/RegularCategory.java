public class RegularCategory extends MovieCategory {

    @Override
    public double calculateCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
