import TextStatement;
import HtmlStatement;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    private TextStatement textStatement = new TextStatement();
    private HtmlStatement htmlStatement = new HtmlStatement(); // NOVO NO COMMIT 18

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    // Texto (continua igual)
    public String textStatement() {
        return textStatement.value(this);
    }

    // HTML (NOVO)
    public String htmlStatement() {
        return htmlStatement.value(this);
    }

    // --- Métodos auxiliares usados pelos Statements ---

    public double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}
