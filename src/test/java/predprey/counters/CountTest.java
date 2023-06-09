package predprey.counters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    @BeforeEach
    void setUp() {
        count.set(0);
    }

    @Test
    void get() {
        assertEquals(count.get(), 0);
    }

    @Test
    void set() {
        count.set(-1);
        assertEquals(count.get(), -1);

        count.set(1);
        assertEquals(count.get(), 1);
    }

    @Test
    void inc() {
        for (int i = 0; i < 5; ++i)
            count.inc();
        assertEquals(count.get(), 5);
    }

    private Count count = new Count();
}