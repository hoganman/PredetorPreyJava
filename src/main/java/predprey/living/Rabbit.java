package predprey.living;

import predprey.counters.Count;

/**
 * Rabbit.java -- The prey in this model that feeds on grass
 */
class Rabbit extends AbstractLiving {

    /**
     * Creates a prey rabbit that feeds on grass
     *
     * @param row Row in world grid
     * @param col Column in the world grid
     * @param age Age of the living being
     */
    Rabbit(int row, int col, int age) {
        this.row = row;
        column = col;
        this.age = age;
    }

    @Override
    AbstractLiving next(World world) {
        computeNeighbors(world);
        // Too many foxes
        if (Fox.neighborCount.get() >= Rabbit.neighborCount.get())
            return (new Empty(row, column));
        // Too old, dies
        else if (age > LIFE_EXPECTENCY)
            return (new Empty(row, column));
        // Too few resources
        else if (Rabbit.neighborCount.get() == 0)
            return (new Empty(row, column));
        return (new Rabbit(row, column, age + 1));
    }

    /** Represent the rabbit on a grid using a character
     *
     * @return The character 'R'
     */
    @Override
    char toChar() { return 'R'; }

    public String toString() { return String.format("Rabbit(age=%d)", age); }

    @Override
    Count getCount() { return neighborCount; }

    private int age;
    static Count neighborCount = new Count();
    private final int LIFE_EXPECTENCY = 3;
}
