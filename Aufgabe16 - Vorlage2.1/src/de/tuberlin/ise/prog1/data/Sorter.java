package de.tuberlin.ise.prog1.data;


import java.util.ArrayList;
import java.util.Comparator;

public class Sorter {


    /**
     * A function that sorts a copy of the given array using the
     * {@link Comparable)} interface.
     * @param original array to copy and sort sort
     * @return the sorted array
     */
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> original){
        if(original == null) return null;

        ArrayList<T> workCopy = new ArrayList<>(original);

        workCopy.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });

        return workCopy;
    }

}
