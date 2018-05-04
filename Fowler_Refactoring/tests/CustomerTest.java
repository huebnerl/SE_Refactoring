import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Lars Hübner on 04.05.2018.
 *
 */
class CustomerTest {
    private Customer c1;

    @BeforeEach
    void setUp(){
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        c1 = new Customer("Tweety");
        c1.addRental(r1);
        c1.addRental(r2);
    }

    @Test
    void getName() {
        assertEquals("Tweety", c1.getName());
    }

    @Test
    void statement() {
        String statement =
                "Rental Record for Tweety\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";
        assertEquals(statement, c1.statement());
    }

    @Test
    void addRental() {
        Movie m3 = new Movie("Deadpool", 2);
        Rental r3 = new Rental(m3, 6);
        c1.addRental(r3);
        String statement =
                "Rental Record for Tweety\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "\tDeadpool\t\t6\t6.0\n" +
                "Amount owed is 40.5\n" +
                "You earned 4 frequent renter points";
        assertEquals(statement, c1.statement());
    }
}