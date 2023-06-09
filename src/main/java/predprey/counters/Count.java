package predprey.counters;

/**
 * Count.java - Wrapper for an integer for counting
 * <p>
 * Dedicated counter wrapper with a get, set, and increment operation.
 * Initial count is set to zero.
 */
public class Count {
    /**
     * Set the count initially to zero (0)
     *
     * <p> Use {@link #set(int)} to set a different start value
     */
    public Count() {
        set(0);
    }

    /**
     * Get the current count
     *
     * @return Current count
     */
    public int get() {
        return count;
    }

    /**
     * Set the count to a specified integer value
     *
     * @param count New count value
     */
    public void set(int count) {
        this.count = count;
    }

    /**
     * Increment the count by positive 1 (+1)
     */
    public void inc() {
        ++count;
    }

    /// Members

    // The accumulated or set count
    private int count;
}
