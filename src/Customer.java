import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    // ---- REFACTORED NO COMMIT 5 ----
    public String statement() {

        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : rentals) {
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(each.getCharge())
                    .append("\n");
        }

        result.append("Amount owed is ")
                .append(getTotalCharge())
                .append("\n");

        result.append("You earned ")
                .append(getTotalFrequentRenterPoints())
                .append(" frequent renter points");

        return result.toString();
    }

    private double getTotalCharge() {
        double total = 0;
        for (Rental each : rentals) {
            total += each.getCharge();
        }
        return total;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        for (Rental each : rentals) {
            points += each.getFrequentRenterPoints();
        }
        return points;
    }
}
