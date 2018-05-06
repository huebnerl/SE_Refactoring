import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Lars Hübner on 04.05.2018.
 *
 */
class MovieTest {
    private Movie m1;
    private Movie m2;

    @BeforeEach
    void setUp(){
        m1 = new Movie("movie1", 1);
        m2 = new Movie("movie2", 2);
    }

    @Test
    void getPriceCode() {
        assertEquals(1, m1.getPriceCode(), "Price must be 1");
        assertEquals(2, m2.getPriceCode(), "Price must be 2");
    }

    @Test
    void setPriceCode() {
        m1.setPriceCode(0);
        m2.setPriceCode(1);

        assertEquals(0, m1.getPriceCode(), "Price must be 3");
        assertEquals(1, m2.getPriceCode(), "Price must be 4");
    }

    @Test
    void getTitle() {
        assertEquals("movie1", m1.getTitle(), "Title must be movie1");
        assertEquals("movie2", m2.getTitle(), "Title must be movie2");
    }

}