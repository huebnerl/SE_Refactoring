/**
 * Created by Lars Hübner on 05.05.2018.
 *
 */
public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getFee(int daysRented){
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented){
        return (daysRented > 1) ? 2 : 1;
    }
}
