package de.tuberlin.ise.prog1.investments;


public class BubbleSort {

    /**
     * creates a flat copy of the original array,
     * thus only the object references are copyed not the objects at these references.
     * @param original
     * @return copy of the original array or null if original was null
     */
	
    private static Investment[] copy(Sortable[] original){
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
    
    public static Investment[] sort(Investment[] original){
    	Investment [] copy1 = copy(original);
    	
        for (int i = copy1.length; i > 1; i--){
        	
        	for(int h = 0; h < i-1; h++){
        		
        	if (copy1[h].compareTo(copy1[h+1])==1){
        	
        	swap (copy1, h, h+1);
 
        	} else{
        		copy1 = copy1;
        	}}
        }
        return copy1;
    	
    }

    /**
     * swap content of the array
     * @param workCopy
     * @param i
     * @param j
     */
    
    private static void swap(Sortable[] workCopy, int i,int j) {
        Sortable tmp = workCopy[i];
        workCopy[i] = workCopy[j];
        workCopy[j] = tmp;
    }

}
