public class TextStatement {

    public String value(Customer customer) {
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        for (Rental rental : customer.getRentals()) {
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(rental.getCharge())
                    .append("\n");
        }

        result.append("Amount owed is ").append(customer.getTotalCharge()).append("\n");
        result.append("You earned ").append(customer.getTotalFrequentRenterPoints()).append(" frequent renter points");

        return result.toString();
    }
}