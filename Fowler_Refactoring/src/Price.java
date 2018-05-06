/**
 * Created by Lars Hübner on 06.05.2018.
 *
 */
abstract class Price {
    abstract int getPriceCode();

    abstract double getFee(int daysRented);

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
