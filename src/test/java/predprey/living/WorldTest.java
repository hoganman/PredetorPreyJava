package predprey.living;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void next() {
        World test1 = new World(3);
        for (int row = 0; row < 3; ++row)
            for (int col = 0; col < 3; ++col)
                assertTrue(test1.getCell(row, col) instanceof Empty);

    }
}