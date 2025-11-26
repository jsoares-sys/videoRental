import Customer;
import Rental;

public class HtmlStatement extends Statement {

    @Override
    protected String headerString(Customer customer) {
        return "<h1>Rental Record for <em>" + customer.getName() + "</em></h1><p>\n";
    }

    @Override
    protected String eachRentalString(Rental rental) {
        return rental.getMovie().getTitle() + ": " + rental.getCharge() + "<br>\n";
    }

    @Override
    protected String footerString(Customer customer) {
        return "<p>You owe <em>" + customer.getTotalCharge() + "</em><p>\n"
                + "On this rental you earned <em>" + customer.getTotalFrequentRenterPoints()
                + "</em> frequent renter points<p>";
    }
}
