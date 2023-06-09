package predprey.living;

import predprey.counters.Count;

class Grass extends AbstractLiving {
    /** Creates grazing grass for rabbits to feed.
     *
     * @param row Row of the entity
     * @param col Column of the entity
     */
    Grass(int row, int col) {
        this.row = row;
        column = col;
    }


    @Override
    AbstractLiving next(World world) {
        computeNeighbors(world);
        // Plenty of resources, rabbits mate
        if (Grass.neighborCount.get() > 2 * Rabbit.neighborCount.get())
            return (new Rabbit(row, column, 0));
        // Grass remains as too few rabbits
        else if (Grass.neighborCount.get() > Rabbit.neighborCount.get())
            return new Grass(row, column);
        // Too many rabbits eat grass
        return new Empty(row, column);
    }

    /** Represent the grass on a grid using a 'G' character
     *
     * @return The character 'G'
     */
    @Override
    char toChar() {
        return 'G';
    }

    @Override
    Count getCount() { return neighborCount; }

    static Count neighborCount = new Count();
}
