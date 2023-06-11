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

    @Test
    void testClearNeighborsResetsAllCounters() {
        World test1 = new World(1);
        test1.clearNeighborCounts();
        assertEquals(0, Fox.neighborCount.get());
        assertEquals(0, Rabbit.neighborCount.get());
        assertEquals(0, Grass.neighborCount.get());
        assertEquals(0, Empty.neighborCount.get());
    }
}