import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Lars Hübner on 04.05.2018.
 *
 */
class RentalTest {
    private Movie m1;
    private Movie m2;
    private Rental r1;
    private Rental r2;

    @BeforeEach
    void setUp(){
        m1 = new Movie("movie1", 1);
        m2 = new Movie("movie2", 2);
        r1 = new Rental(m1, 10);
        r2 = new Rental(m2, 5);
    }

    @Test
    void getDaysRented() {
        assertEquals(10, r1.getDaysRented(), "Days must be 10");
        assertEquals(5, r2.getDaysRented(), "Days must be 5");
    }

    @Test
    void getMovie() {
        assertEquals(m1, r1.getMovie(), "Movie must be m1");
        assertEquals(m2, r2.getMovie(), "Movie must be m2");
    }

}