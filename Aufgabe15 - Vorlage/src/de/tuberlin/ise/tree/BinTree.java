package de.tuberlin.ise.tree;

/**
 * A Binary Tree Class that stores {@link TreeData}-Objects
 */
public class BinTree {
	Node root;
	int size = 0;

    /**
     * Insert a new TreeData Object into the three
     * @param data object to be inserted
     */
	public void insert(TreeData data){
		if (root == null){
			root = new Node (data);
			
		} else {
			root.insert(new Node (data));
			
		}
		size++;
	}

    /**
     * Number of elements in the Tree
     * @return
     */
	public int size(){
	    return this.size;
    }

	/**
	 * reursive method that walks over the tree in-order and appends 
	 * the node.data to the stringbuilder
	 * @param node
	 * @param builder
	 */
	private void toString(Node node,StringBuilder builder){
		builder.append("[");
		if(node != null){
			
			if(node.getLeft() != null){
				toString(node.getLeft(),builder);
				builder.append("<");
			} else {
				builder.append("x<");
			}
			
			builder.append(node.getData());
			
			if(node.getRight() != null){
				builder.append(">");
				toString(node.getRight(),builder);
			} else {
				builder.append(">x");
			}
			
		}
		builder.append("]");
	}
	
    /**
     * @return String representaton of this Tree
     */
	public String toString(){
		StringBuilder b = new StringBuilder();
		toString(root,b);
		return b.toString();
	}


    /**
     * finds a TreeData Object equivalent to the one specified
     * @param s
     * @return
     */
	public TreeData find(TreeData s){
		if (root == null){
			return null;
		} else {
			if (root.find(s) != null){
				return root.find(s).data;
			} else {
				return null;
			}
		
		}
	}

   
}
