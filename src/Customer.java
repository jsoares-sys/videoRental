
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    // ============================
    //   MÉTODO ORIGINAL (TEXTO)
    // ============================
    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : rentals) {
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(rental.getCharge())
                    .append("\n");
        }

        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints())
                .append(" frequent renter points");

        return result.toString();
    }

    // ============================
    //   NOVO MÉTODO (HTML)
    // ============================
    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + getName() + "</b></h1><br>");

        for (Rental rental : rentals) {
            result.append(rental.getMovie().getTitle())
                    .append(": ")
                    .append(rental.getCharge())
                    .append("<br>");
        }

        result.append("<p>Amount owed is <b>")
                .append(getTotalCharge())
                .append("</b></p>");

        result.append("<p>You earned <b>")
                .append(getTotalFrequentRenterPoints())
                .append("</b> frequent renter points</p>");

        return result.toString();
    }

    // ============================
    //   MÉTODOS AUXILIARES
    // ============================

    private double getTotalCharge() {
        double total = 0;
        for (Rental rental : rentals) {
            total += rental.getCharge();
        }
        return total;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        for (Rental rental : rentals) {
            points += rental.getFrequentRenterPoints();
        }
        return points;
    }
}
