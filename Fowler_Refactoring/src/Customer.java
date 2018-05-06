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

    public String htmlStatement() {
        Enumeration enum_rentals = rentals.elements();
        String result = "<h1> Rental Record for <em>" + this.getName() + "</em></h1><p>" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            // show figures for the rental
            result += each.getMovie().getTitle() + ": " + each.getDaysRented() + ", " + String.valueOf(each.getPrice()) + "<br>" + "\n";
        }
        //add footer lines
        result += "</p><p> You owe <em>" + String.valueOf(getTotalPrice()) + "</em></p>" + "\n";
        result += "<p> You earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent renter points </P>" + "\n";

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
    