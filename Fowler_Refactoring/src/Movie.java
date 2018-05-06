public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private Price price;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg){
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Price code not valid.");
        }
    }

    public String getTitle() {
        return title;
    }

   public double getPrice(int daysRented){
       double result = 0;
       switch (getPriceCode()) {
           case Movie.REGULAR:
               result += 2;
               if (daysRented > 2)
                   result += (daysRented - 2) * 1.5;
               break;
           case Movie.NEW_RELEASE:
               result += daysRented * 3;
               break;
           case Movie.CHILDREN:
               result += 1.5;
               if (daysRented > 3)
                   result += (daysRented - 3) * 1.5;
               break;
           default:
               break;
       }
       return result;
   }

    public int getFrequentRenterPoints(int daysRented){
        int frequentRenterPoints = 0;

        // add frequent renter points
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }
}