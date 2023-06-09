package predprey.living;

import predprey.counters.Count;

/**
 * Fox.java -- The predator in this model that feeds on a rabbit
 */
class Fox extends AbstractLiving {

    /**
     * Creates a predator fox that feeds on a rabbit
     *
     * @param row Row in world grid
     * @param col Column in the world grid
     * @param age Age of the living being
     */
    public Fox(int row, int col, int age) {
        this.row = row;
        column = col;
        this.age = age;
    }

    @Override
    AbstractLiving next(World world) {
        computeNeighbors(world);
        // Too many foxes
        if (Fox.neighborCount.get() > 5)
            return (new Empty(row, column));
        // Too old, dies
        else if (age > LIFE_EXPECTENCY)
            return (new Empty(row, column));
        // Too few resources
        else if (Rabbit.neighborCount.get() == 0)
            return (new Empty(row, column));
        return (new Fox(row, column, age + 1));
    }

    /** Represent the fox on a grid using a character
     *
     * @return The character 'F'
     */
    @Override
    char toChar() { return 'F'; }

    public String toString() {return String.format("Fox(age=%d)", age);}

    @Override
    Count getCount() { return neighborCount; }

    static Count neighborCount = new Count();
    private int age;
    private final int LIFE_EXPECTENCY = 5;
}
