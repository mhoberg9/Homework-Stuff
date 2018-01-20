package de.tuberlin.ise.tree;

/**
 * This interface is used to enable objects to be sorted, by defining a deterministic method to rank objects
 */
public interface TreeData {

    /**
     * Retuns a IntRepresentation of this object, that can be used for definin gan
     * order of all TreeData Object.
     *
     * This number must always be the same for this Object
     * @return
     */
    public int getIntValue();

    /**
     * A Method used to compare TreeData Objects
     * @param l
     * @param r
     * @return
     */
    public static int compareTo(TreeData l,TreeData r){
        return Integer.compare(l.getIntValue(),r.getIntValue());
    }

}
