public class HtmlStatement extends Statement {

    @Override
    protected String header(Customer customer) {
        return "<h1>Rental Record for <b>" + customer.getName() + "</b></h1><br>";
    }

    @Override
    protected String eachRental(Rental rental) {
        return rental.getMovie().getTitle() + ": " +
                rental.getCharge() + "<br>";
    }

    @Override
    protected String footer(Customer customer) {
        return "<p>Amount owed is <b>" + getTotalCharge(customer) + "</b></p>" +
                "<p>You earned <b>" + getTotalFrequentRenterPoints(customer) +
                "</b> frequent renter points</p>";
    }
}
