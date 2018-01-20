package de.tuberlin.ise.prog1.model;


public class BubbleSort {

    /**
     * creates a flat copy of the original array,
     * thus only the object references are copyed not the objects at these references.
     * @param original
     * @return copy of the original array or null if original was null
     */
    private static Investment[] copy(Investment[] original){
        if(original == null) return null;

        Investment[] nCopy = new Investment[original.length];
        System.arraycopy(original,0,nCopy,0,original.length);
        return nCopy;
    }

    /**
     * A function that sorts a copy of the given array using the
     * {@link Sortable#compareTo(Investment, Investment)} fucntion.
     * @param original array to copy and sort sort
     * @return the sorted array
     */
    public static Sortable[] sort(Investment[] original){
        if(original == null) return null;

        Investment[] workCopy = copy(original);

        boolean changed = false;
        do {
            changed = false;
            for (int a = 0; a < workCopy.length - 1; a++) {
                if (workCopy[a].compareTo((Investment) workCopy[a + 1]) > 0) {
                    swap(workCopy, a,a+1);
                    changed = true;
                }
            }
        } while (changed);
        return workCopy;
    }

    private static void swap(Investment[] workCopy, int i,int j) {
        Investment tmp = workCopy[i];
        workCopy[i] = workCopy[j];
        workCopy[j] = tmp;
    }

}
