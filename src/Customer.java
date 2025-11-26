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

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;

            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : rentals) {
            double thisAmount = amountFor(each);
            frequentRenterPoints++;

            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
                frequentRenterPoints++;

            result.append("\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n");
            totalAmount += thisAmount;
        }

        result.append("Amount owed is " + totalAmount + "\n");
        result.append("You earned " + frequentRenterPoints + " frequent renter points");

        return result.toString();
    }
}
