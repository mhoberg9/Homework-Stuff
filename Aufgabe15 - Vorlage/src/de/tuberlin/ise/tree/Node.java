package de.tuberlin.ise.tree;

/**
 * This class is used to create a node and search for an object.
 * 
 * @author maltehoberg
 *
 */

public class Node {

	/**
	 * Attributes
	 */

	Node left;
	Node right;
	TreeData data;

	/**
	 * Constructor
	 * 
	 * @param data
	 */

	Node(TreeData data) {
		this.data = data;
	}

	/**
	 * Getters & Setters
	 * 
	 * @return
	 */

	public TreeData getData() {
		return data;
	}

	public void setData(TreeData data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * This method is used to insert a new node.
	 * 
	 * @param n
	 */
	public void insert(Node n) {

		if (TreeData.compareTo(n.data, this.data) == -1) {
			if (this.left == null) {
				this.left = n;
			} else {
				this.left.insert(n);
			}
		} else if (TreeData.compareTo(n.data, this.data) == 1) {
			if (this.right == null) {
				this.right = n;
			} else {
				this.right.insert(n);
			}
		} else if (TreeData.compareTo(n.data, this.data) == 0) {
			return;
		}
	}

	/**
	 * This method is used to search through a tree for a certain object
	 * 
	 * @param data
	 * @return
	 */

	public Node find(TreeData data) {
		if (TreeData.compareTo(data, this.data) == 0) {
			return this;
		} else if (TreeData.compareTo(data, this.data) == -1) {
			if (this.left == null) {
				if (this.right != null) {
					return this.right.find(data);
				} else {
					return null;
				}
			} else {
				return this.left.find(data);
			}
		} else if (TreeData.compareTo(data, this.data) == 1) {
			if (this.right == null) {
				if (this.left != null) {
					return this.left.find(data);
				} else {
					return null;
				}
			} else {
				return this.right.find(data);
			}
		}
		return null;
	}

}
