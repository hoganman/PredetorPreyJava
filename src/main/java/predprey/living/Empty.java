package predprey.living;

import predprey.counters.Count;

/**
 * Empty.java -- The empty cell in the world
 */
class Empty extends AbstractLiving {
    /**
     * The empty cell in the world
     *
     * @param row Row of the entity
     * @param col Column of the entity
     */
    Empty(int row, int col) {
        this.row = row;
        column = col;
    }

    @Override
    Count getCount() { return neighborCount; }

    @Override
    AbstractLiving next(World world) {
        computeNeighbors(world);
        if (Rabbit.neighborCount.get() > 2)
            return (new Fox(row, column, 0));
        else if (Grass.neighborCount.get() > 4)
            return (new Rabbit(row, column, 0));
        else if (Grass.neighborCount.get() > 0)
            return (new Grass(row, column));
        return (new Empty(row, column));
    }

    /**
     * Represent the empty space with a period '.' character.
     *
     * @return The '.' character
     */
    @Override
    char toChar() { return '.'; }

    static Count neighborCount = new Count();
}
