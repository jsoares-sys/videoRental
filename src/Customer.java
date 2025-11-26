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

    // 👉 NOVO NO COMMIT 7
    public String htmlStatement() {

        StringBuilder result = new StringBuilder("<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n");

        for (Rental each : rentals) {
            result.append(each.getMovie().getTitle())
                    .append(": ")
                    .append(each.getCharge())
                    .append("<br>\n");
        }

        result.append("<p>You owe <em>")
                .append(getTotalCharge())
                .append("</em></p>\n");

        result.append("<p>On this rental you earned <em>")
                .append(getTotalFrequentRenterPoints())
                .append("</em> frequent renter points</p>");

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
