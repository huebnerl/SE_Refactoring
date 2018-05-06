/**
 * Created by Lars Hübner on 06.05.2018.
 *
 */
public class RegularPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getFee(int daysRented){
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
