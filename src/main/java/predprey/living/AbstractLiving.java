/// AbstractLiving.java -- Superclass for all living beings
package predprey.living;

import predprey.counters.Count;

public abstract class AbstractLiving {

    /**
     * A counter for the number of entities
     *
     * @return The counter
     */
    abstract Count getCount();

    /** Move the entity into the next cycle
     *
     * @param world The world of the simulation
     * @return      Empty when external factors kill it, else a new living entity
     */
    abstract AbstractLiving next(World world);

    abstract char toChar();

    /**
     * Compute the total number of neighbors for the entity type on the world grid.
     *
     * @param world The world grid
     */
    void computeNeighbors(World world) {
        world.clearNeighborCounts();
        world.cells[row][column].getCount().set(-1);
        for (int row_index = -1; row_index <= 1; ++row_index)
            for (int col_index = -1; col_index <= 1; ++col_index)
                world.cells[row + row_index][column + col_index].getCount().inc();
    }

    int row;
    int column;
}
