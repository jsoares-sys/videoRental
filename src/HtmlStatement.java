
import Customer;
import Rental;

public class HtmlStatement {

    public String value(Customer customer) {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <em>");
        result.append(customer.getName()).append("</em></h1><p>\n");

        for (Rental rental : customer.getRentals()) {
            result.append(rental.getMovie().getTitle())
                    .append(": ")
                    .append(rental.getCharge())
                    .append("<br>\n");
        }

        result.append("<p>You owe <em>")
                .append(customer.getTotalCharge())
                .append("</em><p>\n");

        result.append("On this rental you earned <em>")
                .append(customer.getTotalFrequentRenterPoints())
                .append("</em> frequent renter points<p>");

        return result.toString();
    }
}