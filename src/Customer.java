import TextStatement;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private TextStatement textStatement = new TextStatement(); // NOVO

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

    // EXTRAÍDO NO COMMIT 17
    public String textStatement() {
        return textStatement.value(this);
    }

    
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