public abstract class Statement {

    public String value(Customer customer) {
        StringBuilder result = new StringBuilder();

        result.append(header(customer));

        for (Rental rental : customer.getRentals()) {
            result.append(eachRental(rental));
        }

        result.append(footer(customer));

        return result.toString();
    }

    protected abstract String header(Customer customer);
    protected abstract String eachRental(Rental rental);
    protected abstract String footer(Customer customer);
}
