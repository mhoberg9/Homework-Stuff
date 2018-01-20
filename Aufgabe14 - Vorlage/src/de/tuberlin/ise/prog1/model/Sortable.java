package de.tuberlin.ise.prog1.model;

/**
 * This interface is used to enable objects to be sorted, by defining a deterministic method to rank objects
 */
public interface Sortable {

    /**
     * This methods implements a comparision function between two Investment objects.
     *
     *  This function should return 0 if l and r are equals.
     *  This function should return -1 if l has a lesser rank than r and +1 if r has a lesser rank then l.
     *
     *  Therefore:
     *   - compareTo(l,r) = 1   => l > r
     *   - compareTo(l,r) = -1  => l < r
     *   - compareTo(l,r) = 0   => l = r
     *
     * Attention:
     *   - compareTo(null,null) should always return 0
     *   - compareTo(null,existing_object) shuld always return -1
     *   - compareTo(existing_object,null) shuld always return 1
     * @param l left instance of the investment object
     * @param r right instance of the investment object
     * @return the comparison result
     */
    public int compareTo(Investment l, Investment r);

    /**
     * This function is used to compare this object to any other
     * object using the same functionality as {@link #compareTo(Investment, Investment)}
     *
     * Example implementation could be:
     * <code>
     * public int compareTo(Investment r) {
     *      return compareTo(this,r);
     * }
     * </code>
     *
     * @param r @see compareTo(Investment l,Investment r)
     * @return @see compareTo(Investment l,Investment r)
     */
    public int compareTo(Investment r);

}
