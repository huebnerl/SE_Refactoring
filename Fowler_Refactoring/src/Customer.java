import java.util.*;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getPrice()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalPrice()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalPrice(){
        double result = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()){
            Rental rental = (Rental) enum_rentals.nextElement();
            result += rental.getPrice();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()){
            Rental rental = (Rental) enum_rentals.nextElement();
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}
    