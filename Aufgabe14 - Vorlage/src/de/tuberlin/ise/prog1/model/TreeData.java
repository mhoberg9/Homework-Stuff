package de.tuberlin.ise.prog1.model;

public interface TreeData {

	/**
	 * Should generate int-vale for each object.
	 * This int-value can not be changed later.
	 * @return
	 */
	public int getIntValue();

	/**
	 * A Method used to compare TreeData Objects
	 * 
	 * @param l
	 * @param r
	 * @return
	 */
	public static int compareTo(TreeData l, TreeData r) {
		return Integer.compare(l.getIntValue(), r.getIntValue());
	}
	
	
	

}
