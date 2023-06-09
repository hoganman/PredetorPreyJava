package predprey.living;


/**
 * World.java -- A world represented by a 2D grid
 */
public class World {

    public World(int size) {
        this.size = size;
        cells = new AbstractLiving[this.size][this.size];
        for(int row = 0; row < size; ++row)
            for(int col = 0; col < size; ++col)
                cells[row][col] = new Empty(row, col);
    }

    public void clearNeighborCounts() {
        Fox.neighborCount.set(0);
        Rabbit.neighborCount.set(0);
        Grass.neighborCount.set(0);
        Empty.neighborCount.set(0);
    }

    public void eden() {
//        for (int row = -1; row <= size; ++row) {
//            for (int col = 0; col < size; ++col) {
//            }
        cells[size / 2][size / 2] = new Grass(size / 2, size / 2);
    }

    public String toString() {
        String out = "";
        for (int row = -1; row <= size; ++row) {
            for (int col = 0; col < size; ++col) {
                if (row == -1 || row == size) {
                    out = String.format("%s--", out);
                }
                else {
                    AbstractLiving cell = cells[row][col];
                    out = String.format("%s|%c", out, cell.toChar());
                }
            }
            out = String.format("%s|\n", out);
        }
        out = out.replaceFirst("-[|]", "--");
        out = out.replaceFirst("-[|]", "--");
        return out;
    }

    /** Update the world into the next year iteration
     *
     * @param oldWorld Previous iteration of the world
     */
    public void update(World oldWorld){
        for (int row = 1; row < size - 1; ++row)
            for (int col = 1; col < size - 1; ++col)
                cells[row][col] = oldWorld.cells[row][col].next(oldWorld);
    }

    // The cells of the grid inhabit one living entity
    public AbstractLiving[][] cells;
    // The 1D edge size of the grid, set in constructor
    private final int size;
}
