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


    // ===========================
// MÉTODO EXTRAÍDO (amountFor)
// ===========================
    private double amountFor(Rental rental) {
        return rental.getCharge();
    }


    // ===========================
// CÁLCULO DE PONTOS
// ===========================
    private int frequentRenterPointsFor(Rental rental) {
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
            return 2;
        return 1;
    }


    // ===========================
// STATEMENT REFACTORED
// ===========================
    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");


        for (Rental rental : rentals) {
// adiciona linha do aluguel
            result.append("\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n");
        }


// rodapé
        result.append("Amount owed is " + getTotalCharge() + "\n");
        result.append("You earned " + getTotalFrequentRenterPoints() + " frequent renter points");


        return result.toString();
    }


    // SOMA TOTAL REFACTORED
    private double getTotalCharge() {
        double total = 0;
        for (Rental rental : rentals)
            total += rental.getCharge();
        return total;
    }


    private int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : rentals)
            total += frequentRenterPointsFor(rental);
        return total;
    }
}