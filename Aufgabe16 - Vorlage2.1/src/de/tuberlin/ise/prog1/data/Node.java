package de.tuberlin.ise.prog1.data;


/**
 * Represents a Binary Tree Node
 */
public class Node <T>{
    //left Tree
	private Node<T> left;
	//right Tree
	private Node<T> right;

	//payloadData
	private TreeData data;
	
	public Node(TreeData data) {
		this.data = data;
	}

    /**
     * Tests if this node is a Leaf (if it has no subtrees)
     * @return
     */
	public boolean isLeaf(){
		return left == null && right == null;
	}
	
	public TreeData getData(){
		return data;
	}

    /**
     * Inserts a node into this subtree
     * @param node
     */
	public void insert(Node<T> node){
		//insert right
		if(TreeData.compareTo(this.data,node.data) < 0){
			if(right == null){
				this.right = node;
			} else {
				//forward insert to next node
				this.right.insert(node);
			}
		//insert left
		} else { 
			if(left == null){
				this.left = node;
			} else {
				//forward insert to next node
				this.left.insert(node);
			}
		}
	}

    /**
     * searches for the node that has an euqal payload to the given TreeData
     * @param s the TreeData to look for
     * @return the Node that cointains equivalent TreeData or null if none can be found
     */
	public Node<?> find(TreeData s) {
		int comp = TreeData.compareTo(this.data,s);
		//walk the tree recursivly
		if(comp == 0){
			return this;
		} else if(comp > 0){
			if(left != null) {
				return left.find(s);
			} else {
				return  null;
			}
		} else {
			if(right != null) {
				return right.find(s);
			} else {
				return right;
			}
		}
	}

	public Node<?> getLeft() {
		return left;
	}

	public Node<?> getRight() {
		return right;
	}
	
	public Node<T> delete(TreeData data) {
		//first find the node that we are removing
		int comp = TreeData.compareTo(this.data,data);
		//walk the tree recursivly
		 if(comp > 0){
			if(left != null) {
				left = left.delete(data);
			}
		} else if(comp < 0){
			if(right != null) {
				right = right.delete(data);
			} 
		} else {
			if(left != null){
				//serch for the larges value inside the left tree (this will become our new Groot)
				Node<T> iAMRoot = getNewRootNode((Node<T>) left);
				//update refrences to make this leaf a groot
				iAMRoot.left = left;
				iAMRoot.right = right;
				//return the new Groot
				return iAMRoot;
				
			} else {
				return right;
			}
		}
		return this;
	}

	/**
	 * This method searches the tree starting at root for the larges
	 * leaf to become a new root for this tree.
	 * it then removes the pointer to this new root and returns it.
	 * @param root
	 * @return
	 */
	private Node<T> getNewRootNode(Node<T> root) {
		if(root.isLeaf()){
			return root;
		} else {
			Node<T> iAmRoot;
			if(root.right != null){
				//traverse right
				if(root.right.isLeaf()){
					iAmRoot = root.right;
					root.right = null;
					return iAmRoot;
				} else {
					return getNewRootNode(root.right);
				}
			} else {
				//traverse left
				if(root.left.isLeaf()){
					iAmRoot = root.left;
					root.left = null;
					return iAmRoot;
				} else {
					return getNewRootNode(root.right);
				}
			}
		}
	}
}
